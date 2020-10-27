package kr.or.ddit.post.model;

import java.util.Date;

public class PostVo {
	
	private int post_seq;
	private int post_gn;
	private String post_title;
	private Date post_reg_dt;
	private String post_content;
	private String post_yn;
	private int board_seq;
	private String user_id;
	private int post_p_seq;
	
	public PostVo(String post_title, String post_content, String post_yn,
			int board_seq, String user_id, int post_p_seq) {
		super();
		this.post_title = post_title;
		this.post_content = post_content;
		this.post_yn = post_yn;
		this.board_seq = board_seq;
		this.user_id = user_id;
		this.post_p_seq = post_p_seq;
	}
	public PostVo() {
		
	}
	public int getPost_seq() {
		return post_seq;
	}
	public void setPost_seq(int post_seq) {
		this.post_seq = post_seq;
	}
	public int getPost_gn() {
		return post_gn;
	}
	public void setPost_gn(int post_gn) {
		this.post_gn = post_gn;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public Date getPost_reg_dt() {
		return post_reg_dt;
	}
	public void setPost_reg_dt(Date post_reg_dt) {
		this.post_reg_dt = post_reg_dt;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public String getPost_yn() {
		return post_yn;
	}
	public void setPost_yn(String post_yn) {
		this.post_yn = post_yn;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getPost_p_seq() {
		return post_p_seq;
	}
	public void setPost_p_seq(int post_p_seq) {
		this.post_p_seq = post_p_seq;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + board_seq;
		result = prime * result + ((post_content == null) ? 0 : post_content.hashCode());
		result = prime * result + post_gn;
		result = prime * result + post_p_seq;
		result = prime * result + ((post_reg_dt == null) ? 0 : post_reg_dt.hashCode());
		result = prime * result + post_seq;
		result = prime * result + ((post_title == null) ? 0 : post_title.hashCode());
		result = prime * result + ((post_yn == null) ? 0 : post_yn.hashCode());
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
		PostVo other = (PostVo) obj;
		if (board_seq != other.board_seq)
			return false;
		if (post_content == null) {
			if (other.post_content != null)
				return false;
		} else if (!post_content.equals(other.post_content))
			return false;
		if (post_gn != other.post_gn)
			return false;
		if (post_p_seq != other.post_p_seq)
			return false;
		if (post_reg_dt == null) {
			if (other.post_reg_dt != null)
				return false;
		} else if (!post_reg_dt.equals(other.post_reg_dt))
			return false;
		if (post_seq != other.post_seq)
			return false;
		if (post_title == null) {
			if (other.post_title != null)
				return false;
		} else if (!post_title.equals(other.post_title))
			return false;
		if (post_yn == null) {
			if (other.post_yn != null)
				return false;
		} else if (!post_yn.equals(other.post_yn))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PostVo [post_seq=" + post_seq + ", post_gn=" + post_gn + ", post_title=" + post_title + ", post_reg_dt="
				+ post_reg_dt + ", post_content=" + post_content + ", post_yn=" + post_yn + ", board_seq=" + board_seq
				+ ", user_id=" + user_id + ", post_p_seq=" + post_p_seq + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
