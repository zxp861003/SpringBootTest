package com.zxp.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class HttpUtil
{
	protected static final Logger loger = Logger.getLogger(HttpUtil.class);

	public static byte[] readPosData(HttpServletRequest request) throws Exception
	{
		if (request == null)
			return null;

		byte[] postData = null;
		ByteArrayOutputStream requestBufferSteam = null;
		InputStream requestIn = null;
		try
		{
			byte[] buffer = new byte[256];
			requestIn = request.getInputStream();
			requestBufferSteam = new ByteArrayOutputStream();
			int len = -1;
			while ((len = requestIn.read(buffer)) != -1)
			{
				requestBufferSteam.write(buffer, 0, len);
			}
			postData = requestBufferSteam.toByteArray();
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			try
			{
				if (requestIn != null)
				{
					requestIn.close();
					requestIn = null;
				}
				if (requestBufferSteam != null)
				{
					requestBufferSteam.close();
					requestBufferSteam = null;
				}
			}
			catch (Exception e1)
			{
				throw e1;
			}
		}

		return postData;
	}

	public static String readPosDataAsString(HttpServletRequest request, String charset) throws Exception
	{
		String postText = null;

		byte[] postData = readPosData(request);
		if (postData != null && postData.length > 0)
		{
			loger.error("read post data,length:" + postData.length);
			try
			{
				postText = new String(postData, charset);
				loger.error("read post text:" + postText);
			}
			catch (Exception e)
			{
				throw e;
			}
		}
		else
			loger.error("read post data,length:0");

		return postText;
	}

	public static Properties parseParams(String paramText)
	{
		Properties params = new Properties();
		int len = (paramText != null) ? paramText.length() : 0;
		if (len > 0)
		{
			int scan = 0;
			int pnstart = 0;
			int pvstart = 0;
			boolean foundEqual = false;//只记录第一个=
			String pName = "";
			String pValue = "";
			char ch;
			while (scan < len)
			{
				ch = paramText.charAt(scan);
				switch (ch)
				{
				case '&':
					if (scan > pvstart)
						pValue = paramText.substring(pvstart, scan);

					if (pName.length() > 0)
					{
						params.setProperty(pName, pValue);
					}
					pvstart = pnstart = scan + 1;
					foundEqual = false;
					pName = pValue = "";
					break;
				case '=':
					if (!foundEqual)
					{
						foundEqual = true;
						if (scan > pnstart)
							pName = paramText.substring(pnstart, scan);
						pvstart = scan + 1;
					}
					break;
				}
				scan++;
			}

			if (scan > pvstart)
				pValue = paramText.substring(pvstart, scan);

			if (pName.length() > 0)
			{
				params.setProperty(pName, pValue);
			}
		}
		return params;
	}

	public static Properties parsePosParams(HttpServletRequest request, String charset) throws Exception
	{

		Properties postParams = null;
		try
		{
			postParams = HttpUtil.parseParams(HttpUtil.readPosDataAsString(request, charset));
			if (postParams != null)
			{
				postParams.setProperty("_remoteHost", String.valueOf(request.getRemoteHost()));
				postParams.setProperty("_remotePort", String.valueOf(request.getRemotePort()));
				postParams.setProperty("_requestUrl", request.getRequestURI());
			}
		}
		catch (Exception e)
		{
			throw e;
		}

		return postParams;
	}

	public static void main(String[] args)
	{
//		String keySou = "liudapengXX~";
//		String keyMd5 = MD5.getHashString(keySou);
//		System.out.println("sou=" + keySou + ",md5=" + keyMd5);
//		 
//		String sou = "userId=20032cpd6464990&userKey=MGEyZUF3bFJVUUlIQlFrSUFsb0tBVk5VQ3dCVFVBSUdBVmRVVTFOVEQxVlZVdzVSREZOUkJWRUJEUXBXREFGWEJWc0JBRklMQUF4UVVsTldWeGxLU0FwV0JBb0lWd1FBQWdNTFhRTmNCVnhUVjFsV0JRQUhWd05XQkZCUUJnY0VUMHhMQWcxVlZ3SVBBZ29CQ2c=&appId=1000103&channelAction=HAIMA&cpId=1006&channelId=20032&extInfo=_#774e0a7f6086468285c6d45e9c98f00f&deviceToken=<b12969e2 a7a09826 54a5d6dc 63cf01d2 2b902cb9 f0a99102 d6aede67 e05ca6ca>";
//		System.out.println(sou);
//		System.out.println();
//		Properties pms = parseParams(sou);
//		Iterator ki = pms.keySet().iterator();
//		while (ki.hasNext())
//		{
//			String key = (String) ki.next();
//			System.out.println(key + "=" + pms.getProperty(key));
//		}
	}
}
