package cn.thinking.org.system.sequence;

public class Sequence {

	private String seqName;
	
	public String getSeqName() {
		return seqName;
	}

	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}

	public Integer getCurrentVal() {
		return currentVal;
	}

	public void setCurrentVal(Integer currentVal) {
		this.currentVal = currentVal;
	}

	public Integer getIncrementVal() {
		return incrementVal;
	}

	public void setIncrementVal(Integer incrementVal) {
		this.incrementVal = incrementVal;
	}

	private Integer currentVal;
	
	private Integer incrementVal;
}
