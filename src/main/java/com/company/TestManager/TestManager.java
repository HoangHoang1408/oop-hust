package com.company.TestManager;

import com.company.BaseURL;
import com.company.TestManager.Tests._10GetDetailsAuctions.GetDetailsAuctionsTest;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionTest;
import com.company.TestManager.Tests._12EditAuction.EditAuctionTest;
import com.company.TestManager.Tests._13CreateItem.CreateItemTest;
import com.company.TestManager.Tests._14CreateComment.CreateCommentTest;
import com.company.TestManager.Tests._15GetListComments.GetListCommentsTest;
import com.company.TestManager.Tests._16DeleteComment.DeleteCommentTest;
import com.company.TestManager.Tests._17CreateBid.CreateBidTest;
import com.company.TestManager.Tests._18GetListBids.GetListBidsTest;
import com.company.TestManager.Tests._19GetListCategories.GetListCategoriesTest;
import com.company.TestManager.Tests._1SignUp.SignUpTest;
import com.company.TestManager.Tests._20GetListBrands.GetListBrandsTest;
import com.company.TestManager.Tests._21AcceptMaxBid.AcceptMaxBidTest;
import com.company.TestManager.Tests._22ContactUs.ContactUsTest;
import com.company.TestManager.Tests._23LikeAuction.LikeAuctionTest;
import com.company.TestManager.Tests._24_GetListLikes.GetListLikesTest;
import com.company.TestManager.Tests._25TotalLikesOfAuction.TotalLikesOfAuctionTest;
import com.company.TestManager.Tests._26GetNews.GetNewsTest;
import com.company.TestManager.Tests._27ReadNews.ReadNewsTest;
import com.company.TestManager.Tests._28GetNotifications.GetNotificationsTest;
import com.company.TestManager.Tests._29ReadNotifications.ReadNotificationsTest;
import com.company.TestManager.Tests._2Login.LoginTest;
import com.company.TestManager.Tests._30GetSlider.GetSliderTest;
import com.company.TestManager.Tests._3Logout.LogoutTest;
import com.company.TestManager.Tests._4EditAccount.EditAccountTest;
import com.company.TestManager.Tests._5Search.SearchTest;
import com.company.TestManager.Tests._6GetListAuctions.GetListAuctionsTest;
import com.company.TestManager.Tests._7GetListAuctionsByStatus.GetListAuctionsByStatusTest;
import com.company.TestManager.Tests._8GetListAuctionsByUser.GetListAuctionsByUserTest;
import com.company.TestManager.Tests._9GetListAuctionsByType.GetListAuctionsByTypeTest;
import com.company.constants.Constant;

import java.io.IOException;

// quản lí các test và chạy test được chọn khi có yêu cầu
public class TestManager {

    public void startTest(int apiId, BaseURL baseUrl) {
        Test test = switch (apiId) {
            case 1 -> new SignUpTest(baseUrl, Constant.SIGN_UP);
            case 2 -> new LoginTest(baseUrl, Constant.LOG_IN);
            case 3 -> new LogoutTest(baseUrl, Constant.LOG_OUT);
            case 4 -> new EditAccountTest(baseUrl, Constant.EDIT_ACCOUNT);
            case 5 -> new SearchTest(baseUrl, Constant.SEARCH);
            case 6 -> new GetListAuctionsTest(baseUrl, Constant.GET_LIST_AUCTIONS);
            case 7 -> new GetListAuctionsByStatusTest(baseUrl, Constant.GET_LIST_AUCTIONS_BY_STATUS);
            case 8 -> new GetListAuctionsByUserTest(baseUrl, Constant.GET_LIST_AUCTIONS_BY_USER);
            case 9 -> new GetListAuctionsByTypeTest(baseUrl, Constant.GET_LIST_AUCTIONS_BY_TYPE);
            case 10 -> new GetDetailsAuctionsTest(baseUrl, Constant.GET_DETAILS_AUCTIONS);
            case 11 -> new CreateAuctionTest(baseUrl, Constant.CREATE_AUCTION);
            case 12 -> new EditAuctionTest(baseUrl, Constant.EDIT_AUCTION);
            case 13 -> new CreateItemTest(baseUrl, Constant.CREATE_ITEM);
            case 14 -> new CreateCommentTest(baseUrl, Constant.CREATE_COMMENT);
            case 15 -> new GetListCommentsTest(baseUrl, Constant.GET_LIST_COMMENTS);
            case 16 -> new DeleteCommentTest(baseUrl, Constant.DELETE_COMMENT);
            case 17 -> new CreateBidTest(baseUrl, Constant.CREATE_BID);
            case 18 -> new GetListBidsTest(baseUrl, Constant.GET_LIST_BIDS);
            case 19 -> new GetListCategoriesTest(baseUrl, Constant.GET_LIST_CATEGORIES);
            case 20 -> new GetListBrandsTest(baseUrl, Constant.GET_LIST_BRANDS);
            case 21 -> new AcceptMaxBidTest(baseUrl, Constant.ACCEPT_MAX_BID);
            case 22 -> new ContactUsTest(baseUrl, Constant.CONTACT_US);
            case 23 -> new LikeAuctionTest(baseUrl, Constant.LIKE_AUCTION);
            case 24 -> new GetListLikesTest(baseUrl, Constant.GET_LIST_LIKES);
            case 25 -> new TotalLikesOfAuctionTest(baseUrl, Constant.TOTAL_LIKES_OF_AUCTION);
            case 26 -> new GetNewsTest(baseUrl, Constant.GET_NEWS);
            case 27 -> new ReadNewsTest(baseUrl, Constant.READ_NEWS);
            case 28 -> new GetNotificationsTest(baseUrl, Constant.GET_NOTIFICATIONS);
            case 29 -> new ReadNotificationsTest(baseUrl, Constant.READ_NOTIFICATIONS);
            case 30 -> new GetSliderTest(baseUrl, Constant.GET_SLIDER);
            default -> null;
        };
        if (test == null) return;
        try {
            test.startTest();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Somethings went wrong, try again later!");
        }
    }
}
