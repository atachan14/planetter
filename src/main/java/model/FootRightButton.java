package model;

import jakarta.servlet.http.HttpServletRequest;

import dao.PageDAO;
import dao.TileDAO;
import dao.TweetDAO;
import model.data.AccountData;

public class FootRightButton {
	public static void exe(HttpServletRequest request) {
		switch (request.getParameter("button")) {
		case "星屑を置く":
			putTweet(request);
			return;
		case "星屑を広げる":
			spreadPage(request);
			return;

		case "星屑を並べる":
			lineUpTweet(request);
			return;

		default:
			System.out.println("footRightError Default:" + request.getParameter("button"));
			return;
		}
	}

	static void putTweet(HttpServletRequest request) {
		String value = request.getParameter("value");
		if (!checkValueSize(value, 64)) {
			//あとで実装 フォワードで戻してエラーフラグを受け取らせる かも。
		}
		AccountData acd = (AccountData) request.getSession().getAttribute("acd");

		int tileId = TileDAO.insertTile("tweet", acd);
		TweetDAO.insertTweetInTile(value, acd.getName(), tileId);

	}

	static void spreadPage(HttpServletRequest request) {
		String pageName = request.getParameter("value");
		if (!checkValueSize(pageName, 16)) {
			//あとで実装 フォワードで戻してエラーフラグを受け取らせる かも。
		}
		AccountData acd = (AccountData) request.getSession().getAttribute("acd");
		String acName = acd.getName();

		int tileId = TileDAO.acdToTileId(acd);
		int pageId = PageDAO.insertPage(pageName, acName, tileId);
		System.out.println("spreadPage.pageId:" + pageId);

		TweetDAO.updatePageId(pageId, tileId);
		TileDAO.updateType("page", tileId);
	}

	static void lineUpTweet(HttpServletRequest request) {
		String value = request.getParameter("value");
		if (!checkValueSize(value, 64)) {
			//あとで実装 フォワードで戻してエラーフラグを受け取らせる かも。
		}
		AccountData acd = (AccountData) request.getSession().getAttribute("acd");
		String acName = acd.getName();
//		仮の実装。pageidを持ってきておくようにあとで変える。
		int tileId = TileDAO.acdToTileId(acd);
		int pageId= PageDAO.tileIdToPageId(tileId);
		
		TweetDAO.insertTweetInPage(value, acd.getName(), pageId);
		
	}

	static boolean checkValueSize(String value, int size) {
		if (value.length() > size) {
			return false;
		}
		return true;
	}

}
