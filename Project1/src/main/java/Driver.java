import com.lti.daos.ReimbursementDao;
import com.lti.daos.ReimbursementHibernate;
import com.lti.daos.ReimbursementStatusDao;
import com.lti.daos.ReimbursementStatusHibernate;
import com.lti.daos.ReimbursementTypeDao;
import com.lti.daos.ReimbursementTypeHibernate;
import com.lti.daos.RolesDao;
import com.lti.daos.RolesHibernate;
import com.lti.daos.UserDao;
import com.lti.daos.UserHibernate;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.Reimbursement;
import com.lti.models.ReimbursementStatus;
import com.lti.models.ReimbursementType;
import com.lti.models.Roles;
import com.lti.models.User;

public class Driver {
	static UserDao ud = new UserHibernate();
	static RolesDao rd = new RolesHibernate();
	static ReimbursementDao red = new ReimbursementHibernate();
	static ReimbursementStatusDao rsd = new ReimbursementStatusHibernate();
	static ReimbursementTypeDao rtd = new ReimbursementTypeHibernate();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Roles r = new Roles("Manager");
		User u = new User("user", "pass", "mike", "wilder", "mm.com", r);
		User u1 = new User("user1", "pass", "bob", "forapples", "bf.com", r);
		ReimbursementStatus rs = new ReimbursementStatus("Pending");
		ReimbursementType rt = new ReimbursementType("Dinner");
		Reimbursement re = new Reimbursement(100.00, u, rs, rt);
		Reimbursement re1 = new Reimbursement(100.00, u1, rs, rt);
		rd.addRole(r);
		ud.addUser(u);
		ud.addUser(u1);
		rsd.addStatus(rs);
		rtd.addType(rt);
		red.reimbursementAdded(re);
		red.reimbursementAdded(re);
		red.reimbursementAdded(re1);
//		try {
//			System.out.println(ud.getUserById(1));
//		} catch (UserNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(red.getReimbursementByUserAndStatus(u1, rs));
	}

}
