package com.gdx.game.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.gdx.game.GdxRunner;
import com.gdx.game.profile.ProfileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@ExtendWith(GdxRunner.class)
public class BattleStatusUITest {

    @BeforeEach
    void init() {
        Gdx.gl = mock(GL20.class);
        Gdx.gl20 = mock(GL20.class);
    }

    @Test
    public void testBattleStatusUI_ShouldSucceed() {
        ProfileManager profileManager = ProfileManager.getInstance();
        profileManager.setProperty("currentPlayerXPMax", 200);
        profileManager.setProperty("currentPlayerXP", 0);
        profileManager.setProperty("currentPlayerHPMax", 50);
        profileManager.setProperty("currentPlayerHP", 40);
        profileManager.setProperty("currentPlayerMPMax", 50);
        profileManager.setProperty("currentPlayerMP", 45);
        profileManager.setProperty("currentPlayerLevel", 1);

        BattleStatusUI battleStatusUI = new BattleStatusUI();

        assertThat(battleStatusUI).isNotNull();
        assertThat(battleStatusUI.getChildren().size).isEqualTo(16);
        assertThat(Arrays.stream(battleStatusUI.getChildren().items).count()).isEqualTo(24);
    }
}
