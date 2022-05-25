package com.company.TestManager.Tests._14CreateComment;

import com.company.TestManager.Objects.Comment;
import com.company.TestManager.BaseResponse;

import java.util.ArrayList;

public class CreateCommentResponse extends BaseResponse {

    public Data data;

    public static class Data {
        public ArrayList<Comment> comments;
        public String total;
    }
}
