package com.naver.s3.util;

public class Pager {
	
	private Integer perPage;
	private Integer curPage;
	private Integer curBlock;
	private Integer totalBlock;
	private Integer startNum;
	private Integer lastNum;
	
	public Pager() {
		perPage = 10;
	}

	public Integer getCurBlock() {
		return curBlock;
	}

	public Integer getTotalBlock() {
		return totalBlock;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}


	public Integer getCurPage() {
		if(this.curPage == null) {
			this.curPage = 1;
		}
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	

	
	public void makePager(int totalCount) {
		
		int totalPage = totalCount / perPage;
		if(totalCount % perPage != 0) {
			totalPage++;
		}
		
		int perBlock = 5;
		totalBlock = totalPage / perBlock;
		if(totalPage % perBlock != 0) {
			totalBlock++;
		}
		
		curBlock = curPage/perBlock;
		if(curPage%perBlock != 0) {
			curBlock++;
		}
		
		startNum = (curBlock-1) * perBlock + 1;
		lastNum = curBlock * perBlock;
		
		
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}
		
		
	}
	
	public RowMaker makeRow() {
		//rowNum을 계산함
		int startRow = (this.getCurPage()-1)*perPage + 1;
		int lastRow = this.getCurPage()*perPage;
		
		RowMaker rowMaker = new RowMaker();
		rowMaker.setStartRow(startRow);
		rowMaker.setLastRow(lastRow);
		
		return rowMaker;
	}
	
	

}
