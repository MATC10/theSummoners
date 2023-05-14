package org.thesummoners.DataBase;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.Sex;
import org.thesummoners.model.pokemon.State;
import org.thesummoners.model.pokemon.Type;
import org.thesummoners.model.trainer.Trainer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class PokeCrud {
    public static void createPokemon() {
    }
    public static LinkedList<Pokemon> readPokemon() {
        String query = "select * from pokedex";

        PreparedStatement preparedStatement = null;
        LinkedList<Pokemon> listaPokemon = new LinkedList<>();
        try {
            MysqlDataSource MySQLConnection = new MysqlDataSource();
            preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
            //preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int idPokedex = resultSet.getInt("ID_Pokedex");
                String image = resultSet.getString("Image");
                String imageBack = resultSet.getString("Image_Back");
                int hp = resultSet.getInt("HP");
                int level = resultSet.getInt("Level");
                int attackPower = resultSet.getInt("AttackPower");
                int specialAttack = resultSet.getInt("SpecialAttack");
                int defense = resultSet.getInt("Defense");
                int specialDefense = resultSet.getInt("SpecialDefense");
                int speed = resultSet.getInt("Speed");
                int stamina = resultSet.getInt("Stamina");
                String type1 = resultSet.getString("Type1");
                String type2 = resultSet.getString("Type2");
                String state = resultSet.getString("State");
                String sex = resultSet.getString("Sex");
                int experience = resultSet.getInt("experience");

                listaPokemon.add(new Pokemon(name, idPokedex, image, imageBack, hp, level, attackPower,
                        specialAttack,defense,specialDefense,speed,stamina, Type.valueOf(type1),Type.valueOf(type2),
                        State.valueOf(state), Sex.valueOf(sex), experience));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPokemon;
    }

    public static void updatePokemon() {
        System.out.println(Trainer.getTrainer().getPokemon1());
    }

    public static boolean deletePokemon() {
        return true;
    }
}
