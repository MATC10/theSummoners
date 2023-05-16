package org.thesummoners.bd;

import org.thesummoners.model.objeto.Objeto;
import org.thesummoners.model.pokemon.*;
import org.thesummoners.model.trainer.Trainer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

public class PokemonCRUD {

    public static void createPokemon() {

    }

    public static List<Pokemon> readPokemon() {
        String query = "select * from pokedex";

        PreparedStatement preparedStatement = null;
        LinkedList<Pokemon> listaPokemon = new LinkedList<>();
        try {
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
                        specialAttack,defense,specialDefense,speed,stamina,Type.valueOf(type1),Type.valueOf(type2),
                        State.valueOf(state), Sex.valueOf(sex), experience));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPokemon;
    }


    public static void insertTrainerPokemon(Pokemon pokemon, int equipoOpc) {
        String query = "INSERT INTO pokemon (ID_Pokedex, ID_Trainer, Name, NickName, " +
                "HP, Level, Attack_Power, Fertility, Special_Attack, Special_Defense, Defense, Speed, Stamina, Type_1," +
                "Type_2, State, Sex, Experience, objeto, equipoOpc) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, pokemon.getIdPokedex());
            preparedStatement.setInt(2, 1);
            preparedStatement.setString(3, pokemon.getName());
            preparedStatement.setString(4, pokemon.getNickName());
            preparedStatement.setInt(5, pokemon.getHp());
            preparedStatement.setInt(6, pokemon.getLevel());
            preparedStatement.setInt(7, pokemon.getAttackPower());
            preparedStatement.setInt(8, pokemon.getFertility());
            preparedStatement.setInt(9, pokemon.getSpecialAttack());
            preparedStatement.setInt(10, pokemon.getSpecialDefense());
            preparedStatement.setInt(11, pokemon.getDefense());
            preparedStatement.setInt(12, pokemon.getSpeed());
            preparedStatement.setInt(13, pokemon.getStamina());
            preparedStatement.setString(14, pokemon.getType1().name());
            preparedStatement.setString(15, pokemon.getType2().name());
            preparedStatement.setString(16, pokemon.getState().name());
            preparedStatement.setString(17, pokemon.getSex().name());
            preparedStatement.setInt(18, pokemon.getExperience());

            Objeto objeto = pokemon.getObjeto();
            if (objeto != null) {
                preparedStatement.setString(19, objeto.getName());
            } else {
                preparedStatement.setNull(19, Types.VARCHAR);
            }

            preparedStatement.setInt(20, equipoOpc);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }






    public static void updatePokemon() {
        System.out.println(Trainer.getTrainer().getPokemon1());
    }

    public static boolean deletePokemon() {
        return true;
    }


}
