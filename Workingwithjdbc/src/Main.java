import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.wwjdbc.dao.StoreDao;

public class Main {

	public static void main(String[] args) {
		StoreDao store =new StoreDao();
			try {
				store.selectAll();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | IllegalArgumentException | InvocationTargetException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 

	}

