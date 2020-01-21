package com.plivo.test.PlivoAPIautomation;

public class ChannelResources {

	public static String channelPath() {
		String res = "/channels.create";
		return res;

	}

	public static String joinChannelPath() {
		String res = "/channels.join";
		return res;
	}

	public static String renameChannelPath() {
		String res = "/conversations.rename";
		return res;
	}

	public static String listChannelPath() {
		String res = "/conversations.list";
		return res;
	}

	public static String archiveChannelPath() {
		String res = "/conversations.archive";
		return res;
	}

}
