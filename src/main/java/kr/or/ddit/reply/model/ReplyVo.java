package kr.or.ddit.reply.model;

import java.util.Date;

public class ReplyVo {
	private int reply_seq;
	private String reply_content;
	private Date reply_reg_dt;
	private String reply_yn;
	private int post_seq;
	private String user_id;
	public ReplyVo(int reply_seq, String reply_content, Date reply_reg_dt, String reply_yn, int post_seq,
			String user_id) {
		super();
		this.reply_seq = reply_seq;
		this.reply_content = reply_content;
		this.reply_reg_dt = reply_reg_dt;
		this.reply_yn = reply_yn;
		this.post_seq = post_seq;
		this.user_id = user_id;
	}
	public ReplyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReplyVo [reply_seq=" + reply_seq + ", reply_content=" + reply_content + ", reply_reg_dt=" + reply_reg_dt
				+ ", reply_yn=" + reply_yn + ", post_seq=" + post_seq + ", user_id=" + user_id + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + post_seq;
		result = prime * result + ((reply_content == null) ? 0 : reply_content.hashCode());
		result = prime * result + ((reply_reg_dt == null) ? 0 : reply_reg_dt.hashCode());
		result = prime * result + reply_seq;
		result = prime * result + ((reply_yn == null) ? 0 : reply_yn.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReplyVo other = (ReplyVo) obj;
		if (post_seq != other.post_seq)
			return false;
		if (reply_content == null) {
			if (other.reply_content != null)
				return false;
		} else if (!reply_content.equals(other.reply_content))
			return false;
		if (reply_reg_dt == null) {
			if (other.reply_reg_dt != null)
				return false;
		} else if (!reply_reg_dt.equals(other.reply_reg_dt))
			return false;
		if (reply_seq != other.reply_seq)
			return false;
		if (reply_yn == null) {
			if (other.reply_yn != null)
				return false;
		} else if (!reply_yn.equals(other.reply_yn))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	public int getReply_seq() {
		return reply_seq;
	}
	public void setReply_seq(int reply_seq) {
		this.reply_seq = reply_seq;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public Date getReply_reg_dt() {
		return reply_reg_dt;
	}
	public void setReply_reg_dt(Date reply_reg_dt) {
		this.reply_reg_dt = reply_reg_dt;
	}
	public String getReply_yn() {
		return reply_yn;
	}
	public void setReply_yn(String reply_yn) {
		this.reply_yn = reply_yn;
	}
	public int getPost_seq() {
		return post_seq;
	}
	public void setPost_seq(int post_seq) {
		this.post_seq = post_seq;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
}
