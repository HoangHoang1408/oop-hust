package com.company.TestManager.Tests._15GetListComments;

import com.company.TestManager.BaseResponse;
import com.company.TestManager.Objects.Comment;

import java.util.ArrayList;

public class GetListCommentResponse extends BaseResponse {
    public Data data;
    public static class Data{
        public ArrayList<Comment> comments;
        public String total;
    }
}
