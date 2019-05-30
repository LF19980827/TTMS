package dao;

import Tools.DBUtils;
import entity.Iticket;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-23-16:59
 */
public class ticketDaoImpl extends DBUtils<Iticket> implements IticketDao {
    /**
     * 增加演出票信息
     * @param connection
     * @param iticket
     * @return
     */
    @Override
    public int insert(Connection connection, Iticket iticket) {
        ticketDaoImpl ticketDao = new ticketDaoImpl();
        String sql = "INSERT INTO ticket(seat_id,sched_id,ticket_price,ticket_status,ticket_locked_time)VALUES(?,?,?,?,?)";
        return ticketDao.update(connection,sql,iticket.getSeat_id(),iticket.getSched_id(),iticket.getTicket_price(),
                iticket.getTicket_status(),iticket.getTicket_locked_time());
    }

    /**
     * 根据演出票ID修改演出票信息
     * @param connection
     * @param iticket
     * @return
     */
    @Override
    public int update(Connection connection, Iticket iticket) {
        ticketDaoImpl ticketDao = new ticketDaoImpl();
        String sql = "UPDATE ticket SET seat_id=?,sched_id=?,ticket_price=?,ticket_status=?,ticket_locked_time=? WHERE ticket_id=?";
        return ticketDao.update(connection,sql,iticket.getSeat_id(),iticket.getSched_id(),iticket.getTicket_price(),
                iticket.getTicket_status(),iticket.getTicket_locked_time(),iticket.getTicket_id());
    }

    /**
     * 根据演出票ID查询演出票信息
     * @param connection
     * @param iticket
     * @return
     */
    @Override
    public Iticket select(Connection connection, Iticket iticket) {
        ticketDaoImpl ticketDao = new ticketDaoImpl();
        String sql = "SELECT * FROM ticket WHERE ticket_id=?";
        return ticketDao.get(connection,sql,iticket.getTicket_id());
    }

    /**
     * 根据演出计划显示所有票
     * @param connection
     * @param iticket
     * @return
     */
    @Override
    public List<Iticket> getAll(Connection connection,Iticket iticket) {
        ticketDaoImpl ticketDao = new ticketDaoImpl();
        String sql = "SELECT * FROM ticket WHERE sched_id=?";
        return ticketDao.gets(connection,sql,iticket.getSched_id());
    }

    /**
     * 根据演出票ID判断是否存在
     * @param connection
     * @param iticket
     * @return
     */
    @Override
    public boolean isExist(Connection connection, Iticket iticket) {
        ticketDaoImpl ticketDao = new ticketDaoImpl();
        String sql = "SELECT * FROM ticket WHERE ticket_id=?";
        iticket = ticketDao.get(connection,sql,iticket.getTicket_id());
        if(null == iticket){
            return false;
        }
       return true;
    }
}
