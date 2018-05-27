package com.breo.breo.objects;

import java.io.Serializable;

import lombok.Data;

@Data
public class VideoProperties implements Serializable {
	private static final long serialVersionUID = 1L;

	private int width;
	private int height;
	
}
