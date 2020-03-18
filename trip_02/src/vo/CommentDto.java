package vo;

import java.sql.Date;

public class CommentDto {

	int c_number, b_number;
	String comment_box, writer;
	Date date;

	public int getC_number() {
		return c_number;
	}

	public void setC_number(int c_number) {
		this.c_number = c_number;
	}

	public int getB_number() {
		return b_number;
	}

	public void setB_number(int b_number) {
		this.b_number = b_number;
	}

	public String getComment_box() {
		return comment_box;
	}

	public void setComment_box(String comment_box) {
		this.comment_box = comment_box;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
