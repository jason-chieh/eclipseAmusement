package com.example.parkview.constants;

public enum RtnCode {
	//自己的所有
	SUCCESSFUL(200,"OK"), //
	UPDATE_ERROR(400,"update error"), // 
	DELETE_ERROR(400,"Delete error"), // 
	ANSWER_SUCESS(200,"OK"), // 
	ANSWER_ERROR(400,"error"), // 
	ACCOUNT_AND_PWD_NONE(400,"ACCOUNT_AND_PWD_NONE"), // 
	ACCOUNT_NOTFOUND(400,"ACCOUNT_NOTFOUND"), // 
	PWD_ERROR(400,"PWD_ERROR"), // 
	LOGIN_ERROR(400,"LOGIN_ERROR"), // 
	EMAIL_EXIST(400,"EMAIL_EXIST"), // 
	PLAYER_NO_EXIST(400,"PLAYER_NO_EXIST"), //
	RESERVE_IS_ALREADY(400,"RESERVE_IS_ALREADY"), //
	PLAYDATE_IS_NOT_ALREADY(404,"PLAYDATE_IS_NOT_ALREADY"), //
	
	//育騰的停車場
	SERACH_SUCCESSFUL(200, "Serach successful !"), //
	ADMISSION_SUCCESSFUL(200, "Admission successful !"), //
	PARKING_FEE_CALCULATION_SUCCESSFUL(200, "Parking fee calculation successful !"), //
	DELETE_SUCCESSFUL(200,"Delete successful!!"),//
	PAYMENT_SUCCESSFUL(200, "Payment successful !"), //
	PAYMENT_FAIL(400, "Payment fail !"), //
	ALEREADY_PAID(400, "Already paid !"), //
	LICENSE_PLATE_NUMBER_PARAM_ERROR(400," License plate number param error!"),//
	LICENSE_PLATE_NUMBER_NOT_FOUND(400," License plate number not found!"),//
	IS_ALREADY_PAID(400," Already paid!"),//
	PARAM_ERROR(400," Param error!"),//
	CANNOT_BE_NULL(400,"Cannot be null!!"),//
	NO_DUPLICATE_ADMISSION(400,"No duplicate admission!!"),//
	;
	
	private int code;
	
	private String message;

	private RtnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}


	
}

