package pl.agh.turek.bazy.hibernate.util;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class RandomObjectFetcher {
    public static Object get(Class clazz, Session session) {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.sqlRestriction("1=1 order by random()"));
        criteria.setMaxResults(1);
        return criteria.list().get(0);
    }
}
