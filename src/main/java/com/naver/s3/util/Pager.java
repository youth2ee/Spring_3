package com.naver.s3.util;

public class Pager {
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
=======
>>>>>>> Add_QnA_2
	
	//DB
	private Integer curPage; //현재 페이지 번호
	private Integer perPage; //페이지 당 글의 개수
	
	private Integer startRow; //페이지의 시작 글 번호
	private Integer lastRow; //페이지의 마지막 글 번호
	
	
	//View (JSP)
	private Integer startNum; //블럭 시작번호
	private Integer lastNum; //블럭 마지막 번호
	
	private Integer curBlock; //현재 블럭번호
	private Integer totalBlock; //전체 블럭 개수
<<<<<<< HEAD
	
	
	///// 검색하기
	private String kind; //검색종류
	private String search; //검색어

	
	/////
=======

	/////

>>>>>>> Add_QnA_2
	public Integer getCurPage() {
		if(curPage == null || curPage == 0) {
			curPage = 1;
		}
		return curPage;
	}
<<<<<<< HEAD
>>>>>>> Stashed changes

	private Integer curPage;
	private Integer perPage;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer totalBlock;
	
	public Pager() {
		perPage = 10;
	}
	
<<<<<<< Updated upstream
	
	public Integer getTotalBlock() {
		return totalBlock;
=======
	/////
=======

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	
	public Integer getPerPage() {
		if(perPage == null || perPage == 0) {
			perPage = 10;
		}
		return perPage;
	}

	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	
	/////
	
>>>>>>> Add_QnA_2
	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getLastRow() {
		return lastRow;
<<<<<<< HEAD
>>>>>>> Stashed changes
	}

	public Integer getCurBlock() {
		return curBlock;
	}

<<<<<<< Updated upstream
=======
	/////
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
=======
	
	///// 검색
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(search == null) {
			search = "";
		}
		
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
=======
	}

	public void setLastRow(Integer lastRow) {
		this.lastRow = lastRow;
	}

	/////
	
	public Integer getStartNum() {
		return startNum;
	}
	
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	
	public Integer getLastNum() {
		return lastNum;
	}
	
	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}
	
	public Integer getCurBlock() {
		return curBlock;
	}
	
	public void setCurBlock(Integer curBlock) {
		this.curBlock = curBlock;
	}
	
	public Integer getTotalBlock() {
		return totalBlock;
	}
	
	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
>>>>>>> Add_QnA_2
	}
	
	/////
	
<<<<<<< HEAD
	
	
	public void makeRow() {
		this.startRow = (this.getCurPage()-1)*this.getPerPage() + 1;
		this.lastRow = this.getCurPage() * this.getPerPage();
>>>>>>> Stashed changes
	}
	
	public void makePager(int totalCount) {
		//1. 전체 글의 개수 : totalCount
		//2. 전체 페이지의 개수
		int totalPage = totalCount/perPage;
		if(totalCount%perPage != 0) {
			totalPage++;
		}
		
		//3. 몇개의 블럭이 나오느냐. 1~5 : 1블럭 / 6~10 : 2블럭
		//전체블럭의 개수를 구하기
		int perBlock = 5;
		totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		
		//4. curPage를 이용해서 현재블럭의 번호 알아오기
		curBlock = curPage/perBlock;
		if(curPage%perBlock != 0) {
			curBlock++;
		}
		
		//5. curBlock으로 startNum, lastNum 구하기
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
	
=======
	public void makeRow() {
		this.startRow = (this.getCurPage()-1)*this.getPerPage() + 1;
		this.lastRow = this.getCurPage() * this.getPerPage();
	}
	

	public void makePager(int totalCount) {
		//1. 전체 글 개수 가져오기 totalCount
		
		//2. 전체 페이지 개수 가져오기 totalPage	
		int totalPage = totalCount / this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			totalPage++;
		}
		
		//3. 전체 블럭 개수 가져오기 totalBlock
		int perBlock = 5;
		totalBlock = totalPage / perBlock;
		if(totalPage % perBlock != 0) {
			totalBlock++;
		}
		
		//4. 현재 블럭 번호 구하기 curBlock <- 현재페이지로 현재블록번호 구하기
		curBlock = this.getCurPage() / perBlock;
		if(this.getCurPage() % perBlock != 0) {
			curBlock++;
		}
		
		//5. 현재 블럭의 시작페이지번호와 마지막페이지번호 구하기 
		startNum = (curBlock-1) * perBlock + 1;
		lastNum = curBlock * perBlock;
		
		//6. 현재블럭번호가 총블럭번호와 같다면, 그 블럭의 마지막번호는 총 페이지번호와 같다.
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}
		
		
	}
	
	 
	

>>>>>>> Add_QnA_2
}
