package ar.dinosurvival.Juego;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class DinoSurvivalMain extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private Player player;
    private OrthographicCamera camera;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        player = new Player();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

    }

    @Override
    public void render() {
// Limpiamos la pantalla
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        // Actualizamos la lógica del jugador
        float deltaTime = Gdx.graphics.getDeltaTime();
        player.update(deltaTime);

        // 3. Movemos la cámara a la posición exacta del jugador.
        // La posición de la cámara es un vector 3D (X, Y, Z), por eso mandamos 0 en la Z.
        camera.position.set(player.getX(), player.getY(), 0);
        
        // ¡Fundamental! Actualizamos la cámara para que recalcule sus matrices matemáticas
        camera.update();

        // 4. Le avisamos al SpriteBatch que mire a través de los "ojos" de la cámara
        batch.setProjectionMatrix(camera.combined);

        // Dibujamos
        batch.begin();
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
