package com.imudges.meike.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public String Md5(String plainText) {
		StringBuffer buf = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

			// System.out.println("result: " + buf.toString());//32位的加密

			// System.out.println("result: " +
			// buf.toString().substring(8,24));//16位的加密

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buf.toString();
	}

}
