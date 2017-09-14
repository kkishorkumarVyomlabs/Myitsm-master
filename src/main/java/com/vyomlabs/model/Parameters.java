package com.vyomlabs.model;

public class Parameters {
	private String username;
    private String password;
    private String type;
    private String to;
    private String service;
    private String sla;
    private String subject;
    private String text;

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getSla() {
		return sla;
	}

	public void setSla(String sla) {
		this.sla = sla;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Parameters [username=" + username + ", password=" + password + ", type=" + type + ", to=" + to
				+ ", service=" + service + ", sla=" + sla + ", subject=" + subject + ", text=" + text + "]";
	}

   
}
