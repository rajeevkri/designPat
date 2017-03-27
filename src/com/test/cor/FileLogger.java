package com.test.cor;

public class FileLogger extends AbstractLogger {

	public FileLogger(int level) {
		this.level = level;
	}

	@Override
	public void write(String message) {
		System.out.println("File::Logger: " + message);
	}

}
