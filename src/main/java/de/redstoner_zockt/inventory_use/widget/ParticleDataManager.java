package de.redstoner_zockt.inventory_use.widget;

public class ParticleDataManager {

    public final int t_u;
    public final int t_v;
    public float x_o;
    public float y_o;
    public float velocityX;
    public float velocityY;
    public float rotation;
    public float rotationSpeed;
    public float scale;
    public float alpha;
    public int age;
    public final int maxAge;
    public boolean visible;

    public ParticleDataManager(int t_u, int t_v, float x_o, float y_o) {
        this.t_u = t_u;
        this.t_v = t_v;
        this.x_o = x_o;
        this.y_o = y_o;
        this.velocityX = (float) ((Math.random() - 0.5) * 1.2);
        this.velocityY = (float) (-0.15 - Math.random() * 0.25);
        this.rotation = (float) (Math.random() * Math.PI * 2.0);
        this.rotationSpeed = (float) ((Math.random() - 0.5) * 0.12);
        this.scale = (float) (0.7 + Math.random() * 0.6);
        this.alpha = 1.0f;
        this.age = 0;
        this.maxAge = 30 + (int) (Math.random() * 40);
        this.visible = true;
    }

    public void tick(float multiplier) {
        if (!visible) return;
        age++;
        velocityY += 0.035f * multiplier;
        velocityX *= 0.99f;
        velocityY *= 0.995f;
        velocityX += (float) ((Math.random() - 0.5) * 0.02) * multiplier;
        velocityY += (float) ((Math.random() - 0.5) * 0.01) * multiplier;
        x_o += velocityX * multiplier;
        y_o += velocityY * multiplier;
        rotation += rotationSpeed * multiplier;
        float life = age / (float) maxAge;
        if (life < 0.15f) {alpha = life / 0.15f;} else {alpha = 1.0f - ((life - 0.15f) / 0.85f);}
        alpha = Math.clamp(alpha, 0.0f, 1.0f);
        if (age >= maxAge) delete();
    }

    public void delete() {visible = false;alpha = 0.0f;}
}