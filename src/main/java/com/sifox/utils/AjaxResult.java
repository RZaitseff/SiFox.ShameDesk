package com.sifox.utils;

import java.io.Serializable;

public final class AjaxResult implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private boolean success = true;
    private String  message = "";
    private Object  data = null;
  
	public AjaxResult()
    {
    }

    public AjaxResult(final Object data) {
        this.success = true;
        this.message = "OK";
        this.data = data;
    }
    
    public AjaxResult(final boolean success, final Object data, final String message)
    {
    	this.success = success;
    	this.data = data;
    	this.message = message;
    }

    public final boolean isSuccess()
    {
        return this.success;
    }

    public final void setSuccess( final boolean success )
    {
        this.success = success;
    }

    public final String getMessage()
    {
        return this.message;
    }

    public final void setMessage( final String message )
    {
        this.message = message;
    }

    public final Object getData()
    {
        return this.data;
    }

    public final void setData( final Object data )
    {
        this.data = data;
    }

}
