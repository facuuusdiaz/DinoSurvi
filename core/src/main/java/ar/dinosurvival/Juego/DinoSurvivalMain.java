package ar.dinosurvival.Juego;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class DinoSurvivalMain extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private Player player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        player = new Player();
    }

    @Override
    public void render() {
// 1. Limpiamos la pantalla (mantenemos ese color oscuro que tenías)
    ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

    // 2. Le pedimos a LibGDX el tiempo que pasó desde el último fotograma
    // y actualizamos la lógica de movimiento de tu Player
    float deltaTime = Gdx.graphics.getDeltaTime();
    player.update(deltaTime);

    // 3. Dibujamos en pantalla
    batch.begin();
    
    // En vez de usar 'image' y números fijos (140, 210), 
    // le pedimos la textura y la posición actual al jugador
    batch.draw(player.getTexture(), player.getX(), player.getY());
    
    batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        player.dispose(); // Liberamos la textura del jugador también
    }
}
