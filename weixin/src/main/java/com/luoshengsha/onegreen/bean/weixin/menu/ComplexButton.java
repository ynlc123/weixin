package com.luoshengsha.onegreen.bean.weixin.menu;

import java.util.List;

/**
 * 带有子菜单的复杂按钮
 * @author luoshengsha
 * @date 2014年9月3日 下午4:27:37
 */
public class ComplexButton extends Button {
	/**子菜单**/
	private List<Button> subButtons;

	public List<Button> getSubButtons() {
		return subButtons;
	}

	public void setSubButtons(List<Button> subButtons) {
		this.subButtons = subButtons;
	}
}
