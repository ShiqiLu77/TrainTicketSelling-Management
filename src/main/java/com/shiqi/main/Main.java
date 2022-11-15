package com.shiqi.main;

import java.awt.EventQueue;

import com.shiqi.guiCstm.FrameLogin;
import com.shiqi.guiCstm.FrameClientMain;

public class Main {
	private static FrameClientMain frame;// 为什么不能改成JFrame

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//frame = new LoginFrame();
					new FrameLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
