package com.hwj.banking.DaoImp;

import com.hwj.banking.Dao.ProductDao;
import com.hwj.banking.Entity.Product;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImp extends HibernateDaoSupport implements ProductDao {



    @Override
    public List<Product> getProduct() {

        String query = "from Product";
        List<Product> list = this.getHibernateTemplate().loadAll(Product.class);
        return list;
    }
}
