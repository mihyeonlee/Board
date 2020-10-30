package kr.or.ddit.atchfile.model;

public class AtchFileVo {
	private int atch_file_seq; 
	private String file_path ;
	private String file_name ;
	private int post_seq;
	
	public int getAtch_file_seq() {
		return atch_file_seq;
	}
	public void setAtch_file_seq(int atch_file_seq) {
		this.atch_file_seq = atch_file_seq;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public int getPost_seq() {
		return post_seq;
	}
	public void setPost_seq(int post_seq) {
		this.post_seq = post_seq;
	}
	public AtchFileVo(String file_path, String file_name) {
		this.file_path = file_path;
		this.file_name = file_name;
	}
	public AtchFileVo() {
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + atch_file_seq;
		result = prime * result + ((file_name == null) ? 0 : file_name.hashCode());
		result = prime * result + ((file_path == null) ? 0 : file_path.hashCode());
		result = prime * result + post_seq;
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
		AtchFileVo other = (AtchFileVo) obj;
		if (atch_file_seq != other.atch_file_seq)
			return false;
		if (file_name == null) {
			if (other.file_name != null)
				return false;
		} else if (!file_name.equals(other.file_name))
			return false;
		if (file_path == null) {
			if (other.file_path != null)
				return false;
		} else if (!file_path.equals(other.file_path))
			return false;
		if (post_seq != other.post_seq)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AtchFileVo [atch_file_seq=" + atch_file_seq + ", file_path=" + file_path + ", file_name=" + file_name
				+ ", post_seq=" + post_seq + "]";
	}
	
	
	

}
