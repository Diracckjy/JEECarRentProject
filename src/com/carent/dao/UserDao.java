package com.carent.dao;
import java.util.List;
import com.carent.entity.WebUser;

public interface UserDao {
    //��ѯ���а༶��Ϣ
    //List<Clazz> clazzListDao();

    //��½
    WebUser userloginDao(String name, String pwd);

    //��ѯ����ѧ����Ϣ
    //List<WebUser> WebUserListDao(int num,int size);
  //  void WebUserListDao(SxtPageUtil<WebUser> sxtPageUtil);

    //��ѯ���а༶��Ϣ
   // List<Clazz> clazzListDao();

    //ɾ��ѧ����Ϣ
    int deleteWebUserDao(String WebUserid);

    //����ɾ��ѧ����Ϣ
    int deleteWebUsersDao(String WebUserids);

    //���ѧ����Ϣ
    int addWebUserDao(WebUser WebUser);

    //��ѯ����ѧ������Ϣ--����id��ѯ
    WebUser searchWebUserDao(String WebUserid);

    //�޸�ѧ����Ϣ
    int updateWebUserDao(WebUser WebUser);

    //ģ����ѯ
    List<WebUser> WebUserListDaoLike(String name,String calzz);

    //��ѯ�ܼ�¼��
    int selectCountDao();
}

