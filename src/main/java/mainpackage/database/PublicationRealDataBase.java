package mainpackage.database;

import mainpackage.domain.Publication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class PublicationRealDataBase extends JDBCDatabase implements PublicationDataBase {





    @Override
    public void add(Publication publication) {
        Connection connection = null;
        try {
            connection = getConnection();
            System.out.println("соединение с базой данных");
            String sql = "insert into publications(id,title, description) values(default,?,?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, publication.getTitle());
            preparedStatement.setString(2, publication.getDescription());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                publication.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute PublicationsDAOImpl.save()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Optional<Publication> findByTitle(String title) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from Publications where title = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            Publication publication = null;
            if (resultSet.next()) {
                publication = new Publication();
                publication.setId(resultSet.getLong("id"));
                publication.setTitle(resultSet.getString("title"));
                publication.setDescription(resultSet.getString("description"));
            }
            return Optional.ofNullable(publication);
        } catch (Throwable e) {
            System.out.println("Exception while execute PublicationsDAOImpl.getByTitle()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void remove(Publication publication) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "delete from Publications where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, publication.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductDAOImpl.delete()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Publication> getAllProducts() {
        List<Publication> publications = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from Publications";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Publication publication = new Publication();
                publication.setId(resultSet.getLong("id"));
                publication.setTitle(resultSet.getString("title"));
                publication.setDescription(resultSet.getString("description"));
                publications.add(publication);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list PublicationsDAOImpl.getAll()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
        return publications;
    }


}
