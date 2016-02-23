//package org.cocq_sorel.isen.battleship.jpa;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//
//import org.cocq_sorel.isen.battleship.jpa.guice.GuiceRunner;
//import org.cocq_sorel.isen.battleship.jpa.guice.H2DBModule;
//import org.cocq_sorel.isen.battleship.jpa.guice.Modules;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//@RunWith(GuiceRunner.class)
//@Modules({ H2DBModule.class, JPAModule.class })
//public class BattleshipDAOTest {
//
//    @Inject
//    EntityManager em;
//
//    @Inject
//    BattleshipDAO dao;
//
//    @Test
//    public void daoIsInjected() throws Exception {
//        assertThat(dao).isNotNull();
//    }
//
//    @Test
//    public void itCanCreateAGame() throws Exception {
//        BattleshipAdapter game = dao.createNewGame();
//        assertThat(game).isNotNull();
//
//        String token = game.getToken();
//        assertThat(game.getToken()).isNotNull();
//        em.clear();       
//        game = dao.loadFromToken(token);
//        assertThat(game).isNotNull();
//
//    }
//
//    @Test
//    public void itCanPlayWithAJPAGame() throws Exception {
//        BattleshipAdapter game = dao.createNewGame();
//        assertThat(game).isNotNull();
//
//        game.fire(0, 0);
//        game.fire(0, 1);
//        game.fire(0, 2);
//        Assert.assertEquals(game.getCurrentTurn(),(Integer)(3));
//
//
//        String token = game.getToken();
////
//        em.clear();
//        
//        Assert.assertEquals(game.getToken(),token);
////        game = dao.loadFromToken(token);
////        assertThat(game).isNotNull();
////        assertThat(game.getCell(3, 0)).isEqualTo(ChipColour.RED);
////        assertThat(game.getCell(3, 1)).isEqualTo(ChipColour.RED);
////        assertThat(game.getCell(3, 2)).isEqualTo(ChipColour.YELLOW);
////        assertThat(game.getCell(3, 3)).isEqualTo(ChipColour.YELLOW);
////        assertThat(game.getCell(3, 4)).isEqualTo(ChipColour.RED);
//
//    }
//
//    @Test
//    public void adapterManagesTurns() throws Exception {
//        BattleshipAdapter game = dao.createNewGame();
//        assertThat(game.getCurrentTurn()).isNotNull();
//        assertThat(game.getCurrentTurn()).isEqualTo(0);
//        game.fire(0, 0);
//        
//        game = dao.loadFromToken(game.getToken());
//        assertThat(game.getCurrentTurn()).isEqualTo(1);
////        game.play(game.getCurrentTurn(), 3);
////        game = dao.loadFromToken(game.getToken());
////        assertThat(game.getCurrentTurn()).isEqualTo(ChipColour.RED);
//
//    }
//}
