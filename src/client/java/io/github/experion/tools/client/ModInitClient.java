package io.github.experion.tools.client;

import io.github.experion.tools.ModInit;
import io.github.experion.tools.client.initializer.ModClientEvents;
import io.github.experion.tools.client.initializer.ModItemProperties;
import io.github.experion.tools.client.particles.AzaleaExplosionParticle;
import io.github.experion.tools.client.particles.LifestealParticle;
import io.github.experion.tools.client.particles.ShiningParticle;
import io.github.experion.tools.initializer.ModParticles;
import io.github.experion.tools.client.particles.AzaleaEffectParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModInitClient implements ClientModInitializer {
  public static final Logger LOGGER = LoggerFactory.getLogger(ModInitClient.class);

  @Override
  public void onInitializeClient() {
    ModInit.LOGGER.info("Hello, World! (Client initialize)");

    ModClientEvents.register();
    ModItemProperties.bootstrap();

    regParti(ModParticles.AZALEA_EFFECT, AzaleaEffectParticle.Factory::new);
    regParti(ModParticles.AZALEA_EXPLOSIVE, AzaleaExplosionParticle.Factory::new);
    regParti(ModParticles.LIFESTEALED, LifestealParticle.Factory::new);
    regParti(ModParticles.GILDED_SHINE, ShiningParticle.Factory::new);
  }

  private static <T extends ParticleEffect> void regParti(ParticleType<T> var1, ParticleFactoryRegistry.PendingParticleFactory<T> var2) {
      ParticleFactoryRegistry.getInstance().register(var1,var2);
  }


}
