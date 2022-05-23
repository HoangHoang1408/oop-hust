package com.company.Tests.CreateComment;

import com.company.Objects.Comment;
import com.company.Tests.BaseResponse;

import java.util.ArrayList;

public class CreateCommentResponse extends BaseResponse {

    public Data data;

    public static class Data {
        public ArrayList<Comment> comments;
        public String total;
    }
}
