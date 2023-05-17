package org.thesummoners.bd;

import org.thesummoners.model.movement.Movement;
import org.thesummoners.model.objeto.Objeto;
import org.thesummoners.model.pokemon.*;
import org.thesummoners.model.trainer.Trainer;

import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.thesummoners.model.pokemon.Pokemon.getMovementByName;

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

    //HACER SELECT DE UN POKEMON ESPECIFICO
    //(String name, int idPokedex, String image, String imageBack, int hp, int level, int attackPower, int specialAttack, int defense, int specialDefense, int speed, int stamina, Type type1, Type type2, State state, Sex sex, int experience) {
    //
    public static Pokemon readPokemonSpecify(String name) {
        String query = "SELECT * FROM pokedex WHERE name = ?";

        try (PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
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

                return new Pokemon(name, idPokedex, image, imageBack, hp, level, attackPower,
                        specialAttack, defense, specialDefense, speed, stamina, Type.valueOf(type1), Type.valueOf(type2),
                        State.valueOf(state), Sex.valueOf(sex), experience);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//SI NO SE ENCUENTRA EL POKEMON RETORNA NULL
        return null;
    }


//(String name, int idPokedex, String image, String imageBack, int hp, int level, int attackPower, int specialAttack, int defense, int specialDefense, int speed, int stamina, Type type1, Type type2, State state, Sex sex, int experience) {
//
    public static void insertTrainerPokemon(Pokemon pokemon, int equipoOpc) {
        String query = "INSERT INTO pokemon (ID_Pokedex, ID_Trainer, Name, NickName, " +
                "HP, Level, AttackPower, Fertility, SpecialAttack, SpecialDefense, Defense, Speed, Stamina, Type1," +
                "Type2, State, Sex, Experience, objeto, equipoOpc, Image, Image_Back) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            preparedStatement.setString(21, pokemon.getImage());
            preparedStatement.setString(22, pokemon.getImageBack());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

}

    public static List<Pokemon> readPokemonTeam() {
        String query = "SELECT * FROM pokemon WHERE equipoOpc = 1";

        PreparedStatement preparedStatement = null;
        LinkedList<Pokemon> listaPokemon = new LinkedList<>();

        try {
            preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                int idPokedex = resultSet.getInt("ID_Pokedex");
                String image = resultSet.getString("Image");
                String imageBack = resultSet.getString("Image_Back");
                int hp = resultSet.getInt("HP");
                int level = resultSet.getInt("Level");
                int attackPower = resultSet.getInt("AttackPower");
                int fertility = resultSet.getInt("Fertility");
                int specialAttack = resultSet.getInt("SpecialAttack");
                int specialDefense = resultSet.getInt("SpecialDefense");
                int defense = resultSet.getInt("Defense");
                int speed = resultSet.getInt("Speed");
                int stamina = resultSet.getInt("Stamina");
                String type1 = resultSet.getString("Type1");
                String type2 = resultSet.getString("Type2");
                String state = resultSet.getString("State");
                String sex = resultSet.getString("Sex");
                int experience = resultSet.getInt("Experience");
                String objeto = resultSet.getString("objeto");
                String move1 = resultSet.getString("move1");
                String move2 = resultSet.getString("move2");
                String move3 = resultSet.getString("move3");
                String move4 = resultSet.getString("move4");

                // Si move1 está vacío, asignar "Placaje" por defecto
                if (move1 == null) {
                    move1 = "Placaje";
                }

                // Crear objeto Objeto a partir del nombre del objeto
                Objeto objetoPokemon = null;
                if (objeto != null) {
                    objetoPokemon = new Objeto(objeto);
                }

                Pokemon pokemon = new Pokemon(name, idPokedex, image, imageBack, hp, level, attackPower,
                        fertility, specialAttack, specialDefense, defense, speed, stamina,
                        Type.valueOf(type1), Type.valueOf(type2), State.valueOf(state),
                        Sex.valueOf(sex), experience, objetoPokemon);

                // Obtener los movimientos utilizando el método getMovementByName
                pokemon.setLearnedMovement(new Movement[]{
                        getMovementByName(move1),
                        getMovementByName(move2),
                        getMovementByName(move3),
                        getMovementByName(move4)
                });

                listaPokemon.add(pokemon);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPokemon;
    }



    public static List<Pokemon> readPokemonPcBill() {
        String query = "SELECT * FROM pokemon WHERE equipoOpc = 2";

        PreparedStatement preparedStatement = null;
        LinkedList<Pokemon> listaPokemon = new LinkedList<>();

        try {
            preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                int idPokedex = resultSet.getInt("ID_Pokedex");
                String image = resultSet.getString("Image");
                String imageBack = resultSet.getString("Image_Back");
                int hp = resultSet.getInt("HP");
                int level = resultSet.getInt("Level");
                int attackPower = resultSet.getInt("AttackPower");
                int fertility = resultSet.getInt("Fertility");
                int specialAttack = resultSet.getInt("SpecialAttack");
                int specialDefense = resultSet.getInt("SpecialDefense");
                int defense = resultSet.getInt("Defense");
                int speed = resultSet.getInt("Speed");
                int stamina = resultSet.getInt("Stamina");
                String type1 = resultSet.getString("Type1");
                String type2 = resultSet.getString("Type2");
                String state = resultSet.getString("State");
                String sex = resultSet.getString("Sex");
                int experience = resultSet.getInt("Experience");
                String objeto = resultSet.getString("objeto");
                String move1 = resultSet.getString("move1");
                String move2 = resultSet.getString("move2");
                String move3 = resultSet.getString("move3");
                String move4 = resultSet.getString("move4");

                // Si move1 está vacío, asignar "Placaje" por defecto
                if (move1 == null) {
                    move1 = "Placaje";
                }

                // Crear objeto Objeto a partir del nombre del objeto
                Objeto objetoPokemon = null;
                if (objeto != null) {
                    objetoPokemon = new Objeto(objeto);
                }

                Pokemon pokemon = new Pokemon(name, idPokedex, image, imageBack, hp, level, attackPower,
                        fertility, specialAttack, specialDefense, defense, speed, stamina,
                        Type.valueOf(type1), Type.valueOf(type2), State.valueOf(state),
                        Sex.valueOf(sex), experience, objetoPokemon);

                // Obtener los movimientos utilizando el método getMovementByName
                pokemon.setLearnedMovement(new Movement[]{
                        getMovementByName(move1),
                        getMovementByName(move2),
                        getMovementByName(move3),
                        getMovementByName(move4)
                });

                listaPokemon.add(pokemon);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPokemon;
    }


    public static void deleteAllPokemon() {
        String query = "DELETE FROM pokemon";

        try {
            PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertPokemonPcBill(List<Pokemon> pokemonList) {
        String query = "INSERT INTO pokemon (ID_Pokedex, ID_Trainer, Name, NickName, HP, Level, AttackPower, " +
                "Fertility, SpecialAttack, SpecialDefense, Defense, Speed, Stamina, Type1, Type2, State, Sex, " +
                "Experience, objeto, equipoOpc, Image, Image_Back, move1, move2, move3, move4) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query);

            for (Pokemon pokemon : pokemonList) {
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

                preparedStatement.setInt(20, 2);
                preparedStatement.setString(21, pokemon.getImage());
                preparedStatement.setString(22, pokemon.getImageBack());
                if (pokemon.getLearnedMovement().length > 0 && pokemon.getLearnedMovement()[0] != null) {
                    preparedStatement.setString(23, pokemon.getLearnedMovement()[0].getName());
                } else {
                    preparedStatement.setNull(23, Types.VARCHAR);
                }
                if (pokemon.getLearnedMovement().length > 1 && pokemon.getLearnedMovement()[1] != null) {
                    preparedStatement.setString(24, pokemon.getLearnedMovement()[1].getName());
                } else {
                    preparedStatement.setNull(24, Types.VARCHAR);
                }

                if (pokemon.getLearnedMovement().length > 2 && pokemon.getLearnedMovement()[2] != null) {
                    preparedStatement.setString(25, pokemon.getLearnedMovement()[2].getName());
                } else {
                    preparedStatement.setNull(25, Types.VARCHAR);
                }

                if (pokemon.getLearnedMovement().length > 3 && pokemon.getLearnedMovement()[3] != null) {
                    preparedStatement.setString(26, pokemon.getLearnedMovement()[3].getName());
                } else {
                    preparedStatement.setNull(26, Types.VARCHAR);
                }


                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void insertTrainerPokemonTeam(Pokemon[] pokemonArray) {
        String query = "INSERT INTO pokemon (ID_Pokedex, ID_Trainer, Name, NickName, HP, Level, AttackPower, " +
                "Fertility, SpecialAttack, SpecialDefense, Defense, Speed, Stamina, Type1, Type2, State, Sex, " +
                "Experience, objeto, equipoOpc, Image, Image_Back, move1, move2, move3, move4) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query);

            for (Pokemon pokemon : pokemonArray) {
                if(pokemon != null) {
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

                    preparedStatement.setInt(20, 1);
                    preparedStatement.setString(21, pokemon.getImage());
                    preparedStatement.setString(22, pokemon.getImageBack());
                    if (pokemon.getLearnedMovement().length > 0 && pokemon.getLearnedMovement()[0] != null) {
                        preparedStatement.setString(23, pokemon.getLearnedMovement()[0].getName());
                    } else {
                        preparedStatement.setNull(23, Types.VARCHAR);
                    }
                    if (pokemon.getLearnedMovement().length > 1 && pokemon.getLearnedMovement()[1] != null) {
                        preparedStatement.setString(24, pokemon.getLearnedMovement()[1].getName());
                    } else {
                        preparedStatement.setNull(24, Types.VARCHAR);
                    }

                    if (pokemon.getLearnedMovement().length > 2 && pokemon.getLearnedMovement()[2] != null) {
                        preparedStatement.setString(25, pokemon.getLearnedMovement()[2].getName());
                    } else {
                        preparedStatement.setNull(25, Types.VARCHAR);
                    }

                    if (pokemon.getLearnedMovement().length > 3 && pokemon.getLearnedMovement()[3] != null) {
                        preparedStatement.setString(26, pokemon.getLearnedMovement()[3].getName());
                    } else {
                        preparedStatement.setNull(26, Types.VARCHAR);
                    }


                    preparedStatement.executeUpdate();
                }
            }
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
