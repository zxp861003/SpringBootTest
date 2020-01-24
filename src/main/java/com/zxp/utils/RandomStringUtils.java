package com.zxp.utils;

import java.util.Random;

public class RandomStringUtils {
	public static String random(int count, int start, int end, boolean letters, boolean numbers, char[] chars, Random random) {
		if (count == 0) {
			return "";
		} else if (count < 0) {

			throw new IllegalArgumentException("Requested random string length " + count + " is less than 0.");
		}
		if ((start == 0) && (end == 0)) {
			end = 'z' + 1;
			start = ' ';

			if (!letters && !numbers) {
				start = 0;
				end = Integer.MAX_VALUE;
			}
		}

		char[] buffer = new char[count];
		int gap = end - start;
		while (count-- != 0) {
			char ch;
			if (chars == null) {
				ch = (char) (random.nextInt(gap) + start);

			} else {
				ch = chars[random.nextInt(gap) + start];
			}
			if ((letters && Character.isLetter(ch)) || (numbers && Character.isDigit(ch)) || (!letters && !numbers)) {
				if (ch >= 56320 && ch <= 57343) {
					if (count == 0) {

						count++;
					} else {
						// low surrogate, insert high surrogate after putting it
						// in
						buffer[count] = ch;
						count--;
						buffer[count] = (char) (55296 + random.nextInt(128));

					}
				} else if (ch >= 55296 && ch <= 56191) {
					if (count == 0) {
						count++;
					} else {

						// high surrogate, insert low surrogate before putting
						// it in
						buffer[count] = (char) (56320 + random.nextInt(128));
						count--;
						buffer[count] = ch;
					}
				} else if (ch >= 56192 && ch <= 56319) {

					// private high surrogate, no effing clue, so skip it
					count++;
				} else {
					buffer[count] = ch;
				}
			} else {
				count++;
			}
		}
		return new String(buffer);
	}
	
	public static void main(String[] args){
//		String rand = RandomStringUtils.random(12, 48, 57, false, true, null, new Random());
		String rand = RandomStringUtils.random(12, 0, 0, false, true, null, new Random());
		System.out.println(rand);
		System.out.println(MD5.getHashString("sysadmin123456"));
	}
}
