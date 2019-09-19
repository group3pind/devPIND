package com.team.pind.vo;

public class CommentVO {

   String pind_image_savedfile = "";
   String pind_comment_Num = "";
   String pind_comment_Email = "";
   String pind_comment_Content = "";
   String pind_video_Num = "";
   
   public CommentVO () {
   }

   public CommentVO(String pind_image_savedfile, String pind_comment_Num, String pind_comment_Email,
         String pind_comment_Content, String pind_video_Num) {
      super();
      this.pind_image_savedfile = pind_image_savedfile;
      this.pind_comment_Num = pind_comment_Num;
      this.pind_comment_Email = pind_comment_Email;
      this.pind_comment_Content = pind_comment_Content;
      this.pind_video_Num = pind_video_Num;
   }

   public String getPind_image_savedfile() {
      return pind_image_savedfile;
   }

   public void setPind_image_savedfile(String pind_image_savedfile) {
      this.pind_image_savedfile = pind_image_savedfile;
   }

   public String getPind_comment_Num() {
      return pind_comment_Num;
   }

   public void setPind_comment_Num(String pind_comment_Num) {
      this.pind_comment_Num = pind_comment_Num;
   }

   public String getPind_comment_Email() {
      return pind_comment_Email;
   }

   public void setPind_comment_Email(String pind_comment_Email) {
      this.pind_comment_Email = pind_comment_Email;
   }

   public String getPind_comment_Content() {
      return pind_comment_Content;
   }

   public void setPind_comment_Content(String pind_comment_Content) {
      this.pind_comment_Content = pind_comment_Content;
   }

   public String getPind_video_Num() {
      return pind_video_Num;
   }

   public void setPind_video_Num(String pind_video_Num) {
      this.pind_video_Num = pind_video_Num;
   }
   
   

}