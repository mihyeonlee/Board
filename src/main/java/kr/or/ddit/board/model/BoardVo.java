package kr.or.ddit.board.model;

public class BoardVo {
	private int board_seq;
	private String board_name;
	private String board_yn;
	private String user_id;
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_yn() {
		return board_yn;
	}
	public void setBoard_yn(String board_yn) {
		this.board_yn = board_yn;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "BoardVo [board_seq=" + board_seq + ", board_name=" + board_name + ", board_yn=" + board_yn
				+ ", user_id=" + user_id + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((board_name == null) ? 0 : board_name.hashCode());
		result = prime * result + board_seq;
		result = prime * result + ((board_yn == null) ? 0 : board_yn.hashCode());
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
		BoardVo other = (BoardVo) obj;
		if (board_name == null) {
			if (other.board_name != null)
				return false;
		} else if (!board_name.equals(other.board_name))
			return false;
		if (board_seq != other.board_seq)
			return false;
		if (board_yn == null) {
			if (other.board_yn != null)
				return false;
		} else if (!board_yn.equals(other.board_yn))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	public BoardVo(String board_name, String board_yn, String user_id) {
		super();
		this.board_name = board_name;
		this.board_yn = board_yn;
		this.user_id = user_id;
	}
	
	public BoardVo() {
		
	}
	
	

}
