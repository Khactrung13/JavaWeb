package BO;

import java.util.ArrayList;

import DAO.lichsudao;
import Entity.lichsu;

public class lichsubo {
	lichsudao dao = new lichsudao();
	public ArrayList<lichsu> getLichSu(int makh){
		return dao.getLichSu(makh);
	}
}
