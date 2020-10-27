package kr.or.ddit.page.model;


public class PageVo {
	private int page;
	private int pageSize;
	private int board_seq;
	private String board_name;
	public PageVo(int page, int pageSize, int board_seq, String board_name) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.board_seq = board_seq;
		this.board_name = board_name;
	}
	public PageVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((board_name == null) ? 0 : board_name.hashCode());
		result = prime * result + board_seq;
		result = prime * result + page;
		result = prime * result + pageSize;
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
		PageVo other = (PageVo) obj;
		if (board_name == null) {
			if (other.board_name != null)
				return false;
		} else if (!board_name.equals(other.board_name))
			return false;
		if (board_seq != other.board_seq)
			return false;
		if (page != other.page)
			return false;
		if (pageSize != other.pageSize)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PageVo [page=" + page + ", pageSize=" + pageSize + ", board_seq=" + board_seq + ", board_name="
				+ board_name + "]";
	}
	
	

	
	
	
	
	
	
	
}
