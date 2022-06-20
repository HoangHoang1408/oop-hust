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
import com.company.TestManager.Tests._24GetListLikes.GetListLikesTest;
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

// quản lí các test và chạy test được chọn khi có yêu cầu
public class TestManager {

    public void startTest(int apiId, BaseURL baseUrlObject) {
        Test test = switch (apiId) {
            case 1 -> new SignUpTest(baseUrlObject, Constant.SIGN_UP);
            case 2 -> new LoginTest(baseUrlObject, Constant.LOG_IN);
            case 3 -> new LogoutTest(baseUrlObject, Constant.LOG_OUT);
            case 4 -> new EditAccountTest(baseUrlObject, Constant.EDIT_ACCOUNT);
            case 5 -> new SearchTest(baseUrlObject, Constant.SEARCH);
            case 6 -> new GetListAuctionsTest(baseUrlObject, Constant.GET_LIST_AUCTIONS);
            case 7 -> new GetListAuctionsByStatusTest(baseUrlObject, Constant.GET_LIST_AUCTIONS_BY_STATUS);
            case 8 -> new GetListAuctionsByUserTest(baseUrlObject, Constant.GET_LIST_AUCTIONS_BY_USER);
            case 9 -> new GetListAuctionsByTypeTest(baseUrlObject, Constant.GET_LIST_AUCTIONS_BY_TYPE);
            case 10 -> new GetDetailsAuctionsTest(baseUrlObject, Constant.GET_DETAILS_AUCTIONS);
            case 11 -> new CreateAuctionTest(baseUrlObject, Constant.CREATE_AUCTION);
            case 12 -> new EditAuctionTest(baseUrlObject, Constant.EDIT_AUCTION);
            case 13 -> new CreateItemTest(baseUrlObject, Constant.CREATE_ITEM);
            case 14 -> new CreateCommentTest(baseUrlObject, Constant.CREATE_COMMENT);
            case 15 -> new GetListCommentsTest(baseUrlObject, Constant.GET_LIST_COMMENTS);
            case 16 -> new DeleteCommentTest(baseUrlObject, Constant.DELETE_COMMENT);
            case 17 -> new CreateBidTest(baseUrlObject, Constant.CREATE_BID);
            case 18 -> new GetListBidsTest(baseUrlObject, Constant.GET_LIST_BIDS);
            case 19 -> new GetListCategoriesTest(baseUrlObject, Constant.GET_LIST_CATEGORIES);
            case 20 -> new GetListBrandsTest(baseUrlObject, Constant.GET_LIST_BRANDS);
            case 21 -> new AcceptMaxBidTest(baseUrlObject, Constant.ACCEPT_MAX_BID);
            case 22 -> new ContactUsTest(baseUrlObject, Constant.CONTACT_US);
            case 23 -> new LikeAuctionTest(baseUrlObject, Constant.LIKE_AUCTION);
            case 24 -> new GetListLikesTest(baseUrlObject, Constant.GET_LIST_LIKES);
            case 25 -> new TotalLikesOfAuctionTest(baseUrlObject, Constant.TOTAL_LIKES_OF_AUCTION);
            case 26 -> new GetNewsTest(baseUrlObject, Constant.GET_NEWS);
            case 27 -> new ReadNewsTest(baseUrlObject, Constant.READ_NEWS);
            case 28 -> new GetNotificationsTest(baseUrlObject, Constant.GET_NOTIFICATIONS);
            case 29 -> new ReadNotificationsTest(baseUrlObject, Constant.READ_NOTIFICATIONS);
            case 30 -> new GetSliderTest(baseUrlObject, Constant.GET_SLIDER);
            default -> null;
        };
        if (test == null) return;
        test.startTest();

    }
}
