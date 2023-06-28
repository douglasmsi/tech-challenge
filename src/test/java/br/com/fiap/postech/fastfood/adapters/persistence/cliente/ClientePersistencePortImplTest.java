package br.com.fiap.postech.fastfood.adapters.persistence.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ClienteEntity;
import br.com.fiap.postech.fastfood.adapters.persistence.entities.PedidoEntity;
import br.com.fiap.postech.fastfood.core.domain.Cliente;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

class ClientePersistencePortImplTest {
  /**
   * Method under test: {@link ClientePersistencePortImpl#save(Cliente)}
   */
  @Test
  void testSave() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.save(Mockito.<ClienteEntity>any())).thenReturn(new ClienteEntity());
    ClientePersistencePortImpl clientePersistencePortImpl = new ClientePersistencePortImpl(clienteJpaRepository,
        new ModelMapper());
    Cliente actualSaveResult = clientePersistencePortImpl.save(new Cliente());
    assertNull(actualSaveResult.getCpf());
    assertNull(actualSaveResult.getTelefone());
    assertNull(actualSaveResult.getPedidos());
    assertNull(actualSaveResult.getNome());
    assertNull(actualSaveResult.getEndereco());
    assertNull(actualSaveResult.getEmail());
    verify(clienteJpaRepository).save(Mockito.<ClienteEntity>any());
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#save(Cliente)}
   */
  @Test
  void testSave2() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    ArrayList<PedidoEntity> pedidos = new ArrayList<>();
    when(clienteJpaRepository.save(Mockito.<ClienteEntity>any()))
        .thenReturn(new ClienteEntity(1L, "Cpf", "Nome", "Telefone", "Endereco", "jane.doe@example.org", pedidos));
    ClientePersistencePortImpl clientePersistencePortImpl = new ClientePersistencePortImpl(clienteJpaRepository,
        new ModelMapper());
    Cliente actualSaveResult = clientePersistencePortImpl.save(new Cliente());
    assertEquals("Cpf", actualSaveResult.getCpf());
    assertEquals("Telefone", actualSaveResult.getTelefone());
    assertEquals(pedidos, actualSaveResult.getPedidos());
    assertEquals("Nome", actualSaveResult.getNome());
    assertEquals("Endereco", actualSaveResult.getEndereco());
    assertEquals("jane.doe@example.org", actualSaveResult.getEmail());
    verify(clienteJpaRepository).save(Mockito.<ClienteEntity>any());
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#save(Cliente)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testSave3() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: source cannot be null
    //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
    //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
    //       at br.com.fiap.postech.fastfood.adapters.persistence.cliente.ClientePersistencePortImpl.save(ClientePersistencePortImpl.java:26)
    //   See https://diff.blue/R013 to resolve this issue.

    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.save(Mockito.<ClienteEntity>any())).thenReturn(null);
    ClientePersistencePortImpl clientePersistencePortImpl = new ClientePersistencePortImpl(clienteJpaRepository,
        new ModelMapper());
    clientePersistencePortImpl.save(new Cliente());
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#save(Cliente)}
   */
  @Test
  void testSave4() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteEntity clienteEntity = mock(ClienteEntity.class);
    when(clienteEntity.getCpf()).thenReturn("Cpf");
    when(clienteEntity.getEmail()).thenReturn("jane.doe@example.org");
    when(clienteEntity.getEndereco()).thenReturn("Endereco");
    when(clienteEntity.getNome()).thenReturn("Nome");
    when(clienteEntity.getTelefone()).thenReturn("Telefone");
    ArrayList<PedidoEntity> pedidoEntityList = new ArrayList<>();
    when(clienteEntity.getPedidos()).thenReturn(pedidoEntityList);
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.save(Mockito.<ClienteEntity>any())).thenReturn(clienteEntity);
    ClientePersistencePortImpl clientePersistencePortImpl = new ClientePersistencePortImpl(clienteJpaRepository,
        new ModelMapper());
    Cliente actualSaveResult = clientePersistencePortImpl.save(new Cliente());
    assertEquals("Cpf", actualSaveResult.getCpf());
    assertEquals("Telefone", actualSaveResult.getTelefone());
    assertEquals(pedidoEntityList, actualSaveResult.getPedidos());
    assertEquals("Nome", actualSaveResult.getNome());
    assertEquals("Endereco", actualSaveResult.getEndereco());
    assertEquals("jane.doe@example.org", actualSaveResult.getEmail());
    verify(clienteJpaRepository).save(Mockito.<ClienteEntity>any());
    verify(clienteEntity).getCpf();
    verify(clienteEntity).getEmail();
    verify(clienteEntity).getEndereco();
    verify(clienteEntity).getNome();
    verify(clienteEntity).getTelefone();
    verify(clienteEntity).getPedidos();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#save(Cliente)}
   */
  @Test
  void testSave5() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ArrayList<PedidoEntity> pedidoEntityList = new ArrayList<>();
    pedidoEntityList.add(new PedidoEntity());
    ClienteEntity clienteEntity = mock(ClienteEntity.class);
    when(clienteEntity.getCpf()).thenReturn("Cpf");
    when(clienteEntity.getEmail()).thenReturn("jane.doe@example.org");
    when(clienteEntity.getEndereco()).thenReturn("Endereco");
    when(clienteEntity.getNome()).thenReturn("Nome");
    when(clienteEntity.getTelefone()).thenReturn("Telefone");
    when(clienteEntity.getPedidos()).thenReturn(pedidoEntityList);
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.save(Mockito.<ClienteEntity>any())).thenReturn(clienteEntity);
    ClientePersistencePortImpl clientePersistencePortImpl = new ClientePersistencePortImpl(clienteJpaRepository,
        new ModelMapper());
    Cliente actualSaveResult = clientePersistencePortImpl.save(new Cliente());
    assertEquals("Cpf", actualSaveResult.getCpf());
    assertEquals("Telefone", actualSaveResult.getTelefone());
    assertEquals(1, actualSaveResult.getPedidos().size());
    assertEquals("Nome", actualSaveResult.getNome());
    assertEquals("Endereco", actualSaveResult.getEndereco());
    assertEquals("jane.doe@example.org", actualSaveResult.getEmail());
    verify(clienteJpaRepository).save(Mockito.<ClienteEntity>any());
    verify(clienteEntity).getCpf();
    verify(clienteEntity).getEmail();
    verify(clienteEntity).getEndereco();
    verify(clienteEntity).getNome();
    verify(clienteEntity).getTelefone();
    verify(clienteEntity).getPedidos();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#save(Cliente)}
   */
  @Test
  void testSave6() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ArrayList<PedidoEntity> pedidoEntityList = new ArrayList<>();
    pedidoEntityList.add(new PedidoEntity());
    pedidoEntityList.add(new PedidoEntity());
    ClienteEntity clienteEntity = mock(ClienteEntity.class);
    when(clienteEntity.getCpf()).thenReturn("Cpf");
    when(clienteEntity.getEmail()).thenReturn("jane.doe@example.org");
    when(clienteEntity.getEndereco()).thenReturn("Endereco");
    when(clienteEntity.getNome()).thenReturn("Nome");
    when(clienteEntity.getTelefone()).thenReturn("Telefone");
    when(clienteEntity.getPedidos()).thenReturn(pedidoEntityList);
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.save(Mockito.<ClienteEntity>any())).thenReturn(clienteEntity);
    ClientePersistencePortImpl clientePersistencePortImpl = new ClientePersistencePortImpl(clienteJpaRepository,
        new ModelMapper());
    Cliente actualSaveResult = clientePersistencePortImpl.save(new Cliente());
    assertEquals("Cpf", actualSaveResult.getCpf());
    assertEquals("Telefone", actualSaveResult.getTelefone());
    assertEquals(2, actualSaveResult.getPedidos().size());
    assertEquals("Nome", actualSaveResult.getNome());
    assertEquals("Endereco", actualSaveResult.getEndereco());
    assertEquals("jane.doe@example.org", actualSaveResult.getEmail());
    verify(clienteJpaRepository).save(Mockito.<ClienteEntity>any());
    verify(clienteEntity).getCpf();
    verify(clienteEntity).getEmail();
    verify(clienteEntity).getEndereco();
    verify(clienteEntity).getNome();
    verify(clienteEntity).getTelefone();
    verify(clienteEntity).getPedidos();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#save(Cliente)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testSave7() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException: Cannot invoke "org.modelmapper.ModelMapper.map(Object, java.lang.Class)" because "this.modelMapper" is null
    //       at br.com.fiap.postech.fastfood.adapters.persistence.cliente.ClientePersistencePortImpl.save(ClientePersistencePortImpl.java:25)
    //   See https://diff.blue/R013 to resolve this issue.

    ClienteEntity clienteEntity = mock(ClienteEntity.class);
    when(clienteEntity.getCpf()).thenReturn("Cpf");
    when(clienteEntity.getEmail()).thenReturn("jane.doe@example.org");
    when(clienteEntity.getEndereco()).thenReturn("Endereco");
    when(clienteEntity.getNome()).thenReturn("Nome");
    when(clienteEntity.getTelefone()).thenReturn("Telefone");
    when(clienteEntity.getPedidos()).thenReturn(new ArrayList<>());
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.save(Mockito.<ClienteEntity>any())).thenReturn(clienteEntity);
    ClientePersistencePortImpl clientePersistencePortImpl = new ClientePersistencePortImpl(clienteJpaRepository, null);
    clientePersistencePortImpl.save(new Cliente());
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#save(Cliente)}
   */
  @Test
  void testSave8() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.save(Mockito.<ClienteEntity>any())).thenReturn(mock(ClienteEntity.class));
    ModelMapper modelMapper = mock(ModelMapper.class);
    when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<ClienteEntity>>any())).thenReturn(null);
    ClientePersistencePortImpl clientePersistencePortImpl = new ClientePersistencePortImpl(clienteJpaRepository,
        modelMapper);
    assertNull(clientePersistencePortImpl.save(new Cliente()));
    verify(clienteJpaRepository).save(Mockito.<ClienteEntity>any());
    verify(modelMapper, atLeast(1)).map(Mockito.<Object>any(), Mockito.<Class<ClienteEntity>>any());
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findAll()}
   */
  @Test
  void testFindAll() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findAll()).thenReturn(new ArrayList<>());
    assertTrue((new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper())).findAll().isEmpty());
    verify(clienteJpaRepository).findAll();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findAll()}
   */
  @Test
  void testFindAll2() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ArrayList<ClienteEntity> clienteEntityList = new ArrayList<>();
    clienteEntityList.add(new ClienteEntity());
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findAll()).thenReturn(clienteEntityList);
    assertEquals(1, (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper())).findAll().size());
    verify(clienteJpaRepository).findAll();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findAll()}
   */
  @Test
  void testFindAll3() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ArrayList<ClienteEntity> clienteEntityList = new ArrayList<>();
    clienteEntityList.add(new ClienteEntity());
    clienteEntityList.add(new ClienteEntity());
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findAll()).thenReturn(clienteEntityList);
    assertEquals(2, (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper())).findAll().size());
    verify(clienteJpaRepository).findAll();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findAll()}
   */
  @Test
  void testFindAll4() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ArrayList<ClienteEntity> clienteEntityList = new ArrayList<>();
    clienteEntityList
        .add(new ClienteEntity(1L, "Cpf", "Nome", "Telefone", "Endereco", "jane.doe@example.org", new ArrayList<>()));
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findAll()).thenReturn(clienteEntityList);
    assertEquals(1, (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper())).findAll().size());
    verify(clienteJpaRepository).findAll();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findAll()}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testFindAll5() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: source cannot be null
    //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
    //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
    //       at br.com.fiap.postech.fastfood.adapters.persistence.cliente.ClientePersistencePortImpl.lambda$findAll$0(ClientePersistencePortImpl.java:31)
    //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
    //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
    //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    //       at br.com.fiap.postech.fastfood.adapters.persistence.cliente.ClientePersistencePortImpl.findAll(ClientePersistencePortImpl.java:31)
    //   See https://diff.blue/R013 to resolve this issue.

    ArrayList<ClienteEntity> clienteEntityList = new ArrayList<>();
    clienteEntityList.add(null);
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findAll()).thenReturn(clienteEntityList);
    (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper())).findAll();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findAll()}
   */
  @Test
  void testFindAll6() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteEntity clienteEntity = mock(ClienteEntity.class);
    when(clienteEntity.getCpf()).thenReturn("Cpf");
    when(clienteEntity.getEmail()).thenReturn("jane.doe@example.org");
    when(clienteEntity.getEndereco()).thenReturn("Endereco");
    when(clienteEntity.getNome()).thenReturn("Nome");
    when(clienteEntity.getTelefone()).thenReturn("Telefone");
    when(clienteEntity.getPedidos()).thenReturn(new ArrayList<>());

    ArrayList<ClienteEntity> clienteEntityList = new ArrayList<>();
    clienteEntityList.add(clienteEntity);
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findAll()).thenReturn(clienteEntityList);
    assertEquals(1, (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper())).findAll().size());
    verify(clienteJpaRepository).findAll();
    verify(clienteEntity).getCpf();
    verify(clienteEntity).getEmail();
    verify(clienteEntity).getEndereco();
    verify(clienteEntity).getNome();
    verify(clienteEntity).getTelefone();
    verify(clienteEntity).getPedidos();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findAll()}
   */
  @Test
  void testFindAll7() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ArrayList<PedidoEntity> pedidoEntityList = new ArrayList<>();
    pedidoEntityList.add(new PedidoEntity());
    ClienteEntity clienteEntity = mock(ClienteEntity.class);
    when(clienteEntity.getCpf()).thenReturn("Cpf");
    when(clienteEntity.getEmail()).thenReturn("jane.doe@example.org");
    when(clienteEntity.getEndereco()).thenReturn("Endereco");
    when(clienteEntity.getNome()).thenReturn("Nome");
    when(clienteEntity.getTelefone()).thenReturn("Telefone");
    when(clienteEntity.getPedidos()).thenReturn(pedidoEntityList);

    ArrayList<ClienteEntity> clienteEntityList = new ArrayList<>();
    clienteEntityList.add(clienteEntity);
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findAll()).thenReturn(clienteEntityList);
    assertEquals(1, (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper())).findAll().size());
    verify(clienteJpaRepository).findAll();
    verify(clienteEntity).getCpf();
    verify(clienteEntity).getEmail();
    verify(clienteEntity).getEndereco();
    verify(clienteEntity).getNome();
    verify(clienteEntity).getTelefone();
    verify(clienteEntity).getPedidos();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findAll()}
   */
  @Test
  void testFindAll8() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ArrayList<ClienteEntity> clienteEntityList = new ArrayList<>();
    clienteEntityList.add(mock(ClienteEntity.class));
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findAll()).thenReturn(clienteEntityList);
    ModelMapper modelMapper = mock(ModelMapper.class);
    when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(new Cliente());
    assertEquals(1, (new ClientePersistencePortImpl(clienteJpaRepository, modelMapper)).findAll().size());
    verify(clienteJpaRepository).findAll();
    verify(modelMapper).map(Mockito.<Object>any(), Mockito.<Class<Object>>any());
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByNome(String)}
   */
  @Test
  void testFindByNome() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(Optional.of(new ClienteEntity()));
    Cliente actualFindByNomeResult = (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper()))
        .findByNome("Nome");
    assertNull(actualFindByNomeResult.getCpf());
    assertNull(actualFindByNomeResult.getTelefone());
    assertNull(actualFindByNomeResult.getPedidos());
    assertNull(actualFindByNomeResult.getNome());
    assertNull(actualFindByNomeResult.getEndereco());
    assertNull(actualFindByNomeResult.getEmail());
    verify(clienteJpaRepository).findByCpf(Mockito.<String>any());
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByNome(String)}
   */
  @Test
  void testFindByNome2() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    ArrayList<PedidoEntity> pedidos = new ArrayList<>();
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(
        Optional.of(new ClienteEntity(1L, "Cpf", "Nome", "Telefone", "Endereco", "jane.doe@example.org", pedidos)));
    Cliente actualFindByNomeResult = (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper()))
        .findByNome("Nome");
    assertEquals("Cpf", actualFindByNomeResult.getCpf());
    assertEquals("Telefone", actualFindByNomeResult.getTelefone());
    assertEquals(pedidos, actualFindByNomeResult.getPedidos());
    assertEquals("Nome", actualFindByNomeResult.getNome());
    assertEquals("Endereco", actualFindByNomeResult.getEndereco());
    assertEquals("jane.doe@example.org", actualFindByNomeResult.getEmail());
    verify(clienteJpaRepository).findByCpf(Mockito.<String>any());
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByNome(String)}
   */
  @Test
  void testFindByNome3() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteEntity clienteEntity = mock(ClienteEntity.class);
    when(clienteEntity.getCpf()).thenReturn("Cpf");
    when(clienteEntity.getEmail()).thenReturn("jane.doe@example.org");
    when(clienteEntity.getEndereco()).thenReturn("Endereco");
    when(clienteEntity.getNome()).thenReturn("Nome");
    when(clienteEntity.getTelefone()).thenReturn("Telefone");
    ArrayList<PedidoEntity> pedidoEntityList = new ArrayList<>();
    when(clienteEntity.getPedidos()).thenReturn(pedidoEntityList);
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(Optional.of(clienteEntity));
    Cliente actualFindByNomeResult = (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper()))
        .findByNome("Nome");
    assertEquals("Cpf", actualFindByNomeResult.getCpf());
    assertEquals("Telefone", actualFindByNomeResult.getTelefone());
    assertEquals(pedidoEntityList, actualFindByNomeResult.getPedidos());
    assertEquals("Nome", actualFindByNomeResult.getNome());
    assertEquals("Endereco", actualFindByNomeResult.getEndereco());
    assertEquals("jane.doe@example.org", actualFindByNomeResult.getEmail());
    verify(clienteJpaRepository).findByCpf(Mockito.<String>any());
    verify(clienteEntity).getCpf();
    verify(clienteEntity).getEmail();
    verify(clienteEntity).getEndereco();
    verify(clienteEntity).getNome();
    verify(clienteEntity).getTelefone();
    verify(clienteEntity).getPedidos();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByNome(String)}
   */
  @Test
  void testFindByNome4() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ArrayList<PedidoEntity> pedidoEntityList = new ArrayList<>();
    pedidoEntityList.add(new PedidoEntity());
    ClienteEntity clienteEntity = mock(ClienteEntity.class);
    when(clienteEntity.getCpf()).thenReturn("Cpf");
    when(clienteEntity.getEmail()).thenReturn("jane.doe@example.org");
    when(clienteEntity.getEndereco()).thenReturn("Endereco");
    when(clienteEntity.getNome()).thenReturn("Nome");
    when(clienteEntity.getTelefone()).thenReturn("Telefone");
    when(clienteEntity.getPedidos()).thenReturn(pedidoEntityList);
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(Optional.of(clienteEntity));
    Cliente actualFindByNomeResult = (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper()))
        .findByNome("Nome");
    assertEquals("Cpf", actualFindByNomeResult.getCpf());
    assertEquals("Telefone", actualFindByNomeResult.getTelefone());
    assertEquals(1, actualFindByNomeResult.getPedidos().size());
    assertEquals("Nome", actualFindByNomeResult.getNome());
    assertEquals("Endereco", actualFindByNomeResult.getEndereco());
    assertEquals("jane.doe@example.org", actualFindByNomeResult.getEmail());
    verify(clienteJpaRepository).findByCpf(Mockito.<String>any());
    verify(clienteEntity).getCpf();
    verify(clienteEntity).getEmail();
    verify(clienteEntity).getEndereco();
    verify(clienteEntity).getNome();
    verify(clienteEntity).getTelefone();
    verify(clienteEntity).getPedidos();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByNome(String)}
   */
  @Test
  void testFindByNome5() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ArrayList<PedidoEntity> pedidoEntityList = new ArrayList<>();
    pedidoEntityList.add(new PedidoEntity());
    pedidoEntityList.add(new PedidoEntity());
    ClienteEntity clienteEntity = mock(ClienteEntity.class);
    when(clienteEntity.getCpf()).thenReturn("Cpf");
    when(clienteEntity.getEmail()).thenReturn("jane.doe@example.org");
    when(clienteEntity.getEndereco()).thenReturn("Endereco");
    when(clienteEntity.getNome()).thenReturn("Nome");
    when(clienteEntity.getTelefone()).thenReturn("Telefone");
    when(clienteEntity.getPedidos()).thenReturn(pedidoEntityList);
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(Optional.of(clienteEntity));
    Cliente actualFindByNomeResult = (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper()))
        .findByNome("Nome");
    assertEquals("Cpf", actualFindByNomeResult.getCpf());
    assertEquals("Telefone", actualFindByNomeResult.getTelefone());
    assertEquals(2, actualFindByNomeResult.getPedidos().size());
    assertEquals("Nome", actualFindByNomeResult.getNome());
    assertEquals("Endereco", actualFindByNomeResult.getEndereco());
    assertEquals("jane.doe@example.org", actualFindByNomeResult.getEmail());
    verify(clienteJpaRepository).findByCpf(Mockito.<String>any());
    verify(clienteEntity).getCpf();
    verify(clienteEntity).getEmail();
    verify(clienteEntity).getEndereco();
    verify(clienteEntity).getNome();
    verify(clienteEntity).getTelefone();
    verify(clienteEntity).getPedidos();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByNome(String)}
   */
  @Test
  void testFindByNome6() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(Optional.empty());
    assertNull((new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper())).findByNome("Nome"));
    verify(clienteJpaRepository).findByCpf(Mockito.<String>any());
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByNome(String)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testFindByNome7() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException: Cannot invoke "org.modelmapper.ModelMapper.map(Object, java.lang.Class)" because "this.modelMapper" is null
    //       at br.com.fiap.postech.fastfood.adapters.persistence.cliente.ClientePersistencePortImpl.findByNome(ClientePersistencePortImpl.java:38)
    //   See https://diff.blue/R013 to resolve this issue.

    ClienteEntity clienteEntity = mock(ClienteEntity.class);
    when(clienteEntity.getCpf()).thenReturn("Cpf");
    when(clienteEntity.getEmail()).thenReturn("jane.doe@example.org");
    when(clienteEntity.getEndereco()).thenReturn("Endereco");
    when(clienteEntity.getNome()).thenReturn("Nome");
    when(clienteEntity.getTelefone()).thenReturn("Telefone");
    when(clienteEntity.getPedidos()).thenReturn(new ArrayList<>());
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(Optional.of(clienteEntity));
    (new ClientePersistencePortImpl(clienteJpaRepository, null)).findByNome("Nome");
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByNome(String)}
   */
  @Test
  void testFindByNome8() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(Optional.of(mock(ClienteEntity.class)));
    ModelMapper modelMapper = mock(ModelMapper.class);
    Cliente cliente = new Cliente();
    when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(cliente);
    assertSame(cliente, (new ClientePersistencePortImpl(clienteJpaRepository, modelMapper)).findByNome("Nome"));
    verify(clienteJpaRepository).findByCpf(Mockito.<String>any());
    verify(modelMapper).map(Mockito.<Object>any(), Mockito.<Class<Object>>any());
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByCpf(String)}
   */
  @Test
  void testFindByCpf() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(Optional.of(new ClienteEntity()));
    Cliente actualFindByCpfResult = (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper()))
        .findByCpf("Cpf");
    assertNull(actualFindByCpfResult.getCpf());
    assertNull(actualFindByCpfResult.getTelefone());
    assertNull(actualFindByCpfResult.getPedidos());
    assertNull(actualFindByCpfResult.getNome());
    assertNull(actualFindByCpfResult.getEndereco());
    assertNull(actualFindByCpfResult.getEmail());
    verify(clienteJpaRepository).findByCpf(Mockito.<String>any());
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByCpf(String)}
   */
  @Test
  void testFindByCpf2() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    ArrayList<PedidoEntity> pedidos = new ArrayList<>();
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(
        Optional.of(new ClienteEntity(1L, "Cpf", "Nome", "Telefone", "Endereco", "jane.doe@example.org", pedidos)));
    Cliente actualFindByCpfResult = (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper()))
        .findByCpf("Cpf");
    assertEquals("Cpf", actualFindByCpfResult.getCpf());
    assertEquals("Telefone", actualFindByCpfResult.getTelefone());
    assertEquals(pedidos, actualFindByCpfResult.getPedidos());
    assertEquals("Nome", actualFindByCpfResult.getNome());
    assertEquals("Endereco", actualFindByCpfResult.getEndereco());
    assertEquals("jane.doe@example.org", actualFindByCpfResult.getEmail());
    verify(clienteJpaRepository).findByCpf(Mockito.<String>any());
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByCpf(String)}
   */
  @Test
  void testFindByCpf3() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteEntity clienteEntity = mock(ClienteEntity.class);
    when(clienteEntity.getCpf()).thenReturn("Cpf");
    when(clienteEntity.getEmail()).thenReturn("jane.doe@example.org");
    when(clienteEntity.getEndereco()).thenReturn("Endereco");
    when(clienteEntity.getNome()).thenReturn("Nome");
    when(clienteEntity.getTelefone()).thenReturn("Telefone");
    ArrayList<PedidoEntity> pedidoEntityList = new ArrayList<>();
    when(clienteEntity.getPedidos()).thenReturn(pedidoEntityList);
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(Optional.of(clienteEntity));
    Cliente actualFindByCpfResult = (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper()))
        .findByCpf("Cpf");
    assertEquals("Cpf", actualFindByCpfResult.getCpf());
    assertEquals("Telefone", actualFindByCpfResult.getTelefone());
    assertEquals(pedidoEntityList, actualFindByCpfResult.getPedidos());
    assertEquals("Nome", actualFindByCpfResult.getNome());
    assertEquals("Endereco", actualFindByCpfResult.getEndereco());
    assertEquals("jane.doe@example.org", actualFindByCpfResult.getEmail());
    verify(clienteJpaRepository).findByCpf(Mockito.<String>any());
    verify(clienteEntity).getCpf();
    verify(clienteEntity).getEmail();
    verify(clienteEntity).getEndereco();
    verify(clienteEntity).getNome();
    verify(clienteEntity).getTelefone();
    verify(clienteEntity).getPedidos();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByCpf(String)}
   */
  @Test
  void testFindByCpf4() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ArrayList<PedidoEntity> pedidoEntityList = new ArrayList<>();
    pedidoEntityList.add(new PedidoEntity());
    ClienteEntity clienteEntity = mock(ClienteEntity.class);
    when(clienteEntity.getCpf()).thenReturn("Cpf");
    when(clienteEntity.getEmail()).thenReturn("jane.doe@example.org");
    when(clienteEntity.getEndereco()).thenReturn("Endereco");
    when(clienteEntity.getNome()).thenReturn("Nome");
    when(clienteEntity.getTelefone()).thenReturn("Telefone");
    when(clienteEntity.getPedidos()).thenReturn(pedidoEntityList);
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(Optional.of(clienteEntity));
    Cliente actualFindByCpfResult = (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper()))
        .findByCpf("Cpf");
    assertEquals("Cpf", actualFindByCpfResult.getCpf());
    assertEquals("Telefone", actualFindByCpfResult.getTelefone());
    assertEquals(1, actualFindByCpfResult.getPedidos().size());
    assertEquals("Nome", actualFindByCpfResult.getNome());
    assertEquals("Endereco", actualFindByCpfResult.getEndereco());
    assertEquals("jane.doe@example.org", actualFindByCpfResult.getEmail());
    verify(clienteJpaRepository).findByCpf(Mockito.<String>any());
    verify(clienteEntity).getCpf();
    verify(clienteEntity).getEmail();
    verify(clienteEntity).getEndereco();
    verify(clienteEntity).getNome();
    verify(clienteEntity).getTelefone();
    verify(clienteEntity).getPedidos();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByCpf(String)}
   */
  @Test
  void testFindByCpf5() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ArrayList<PedidoEntity> pedidoEntityList = new ArrayList<>();
    pedidoEntityList.add(new PedidoEntity());
    pedidoEntityList.add(new PedidoEntity());
    ClienteEntity clienteEntity = mock(ClienteEntity.class);
    when(clienteEntity.getCpf()).thenReturn("Cpf");
    when(clienteEntity.getEmail()).thenReturn("jane.doe@example.org");
    when(clienteEntity.getEndereco()).thenReturn("Endereco");
    when(clienteEntity.getNome()).thenReturn("Nome");
    when(clienteEntity.getTelefone()).thenReturn("Telefone");
    when(clienteEntity.getPedidos()).thenReturn(pedidoEntityList);
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(Optional.of(clienteEntity));
    Cliente actualFindByCpfResult = (new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper()))
        .findByCpf("Cpf");
    assertEquals("Cpf", actualFindByCpfResult.getCpf());
    assertEquals("Telefone", actualFindByCpfResult.getTelefone());
    assertEquals(2, actualFindByCpfResult.getPedidos().size());
    assertEquals("Nome", actualFindByCpfResult.getNome());
    assertEquals("Endereco", actualFindByCpfResult.getEndereco());
    assertEquals("jane.doe@example.org", actualFindByCpfResult.getEmail());
    verify(clienteJpaRepository).findByCpf(Mockito.<String>any());
    verify(clienteEntity).getCpf();
    verify(clienteEntity).getEmail();
    verify(clienteEntity).getEndereco();
    verify(clienteEntity).getNome();
    verify(clienteEntity).getTelefone();
    verify(clienteEntity).getPedidos();
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByCpf(String)}
   */
  @Test
  void testFindByCpf6() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(Optional.empty());
    assertNull((new ClientePersistencePortImpl(clienteJpaRepository, new ModelMapper())).findByCpf("Cpf"));
    verify(clienteJpaRepository).findByCpf(Mockito.<String>any());
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByCpf(String)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testFindByCpf7() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException: Cannot invoke "org.modelmapper.ModelMapper.map(Object, java.lang.Class)" because "this.modelMapper" is null
    //       at br.com.fiap.postech.fastfood.adapters.persistence.cliente.ClientePersistencePortImpl.findByCpf(ClientePersistencePortImpl.java:47)
    //   See https://diff.blue/R013 to resolve this issue.

    ClienteEntity clienteEntity = mock(ClienteEntity.class);
    when(clienteEntity.getCpf()).thenReturn("Cpf");
    when(clienteEntity.getEmail()).thenReturn("jane.doe@example.org");
    when(clienteEntity.getEndereco()).thenReturn("Endereco");
    when(clienteEntity.getNome()).thenReturn("Nome");
    when(clienteEntity.getTelefone()).thenReturn("Telefone");
    when(clienteEntity.getPedidos()).thenReturn(new ArrayList<>());
    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(Optional.of(clienteEntity));
    (new ClientePersistencePortImpl(clienteJpaRepository, null)).findByCpf("Cpf");
  }

  /**
   * Method under test: {@link ClientePersistencePortImpl#findByCpf(String)}
   */
  @Test
  void testFindByCpf8() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R026 Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:70)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.<init>(DefaultCacheAwareContextLoaderDelegate.java:86)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:198)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:153)
    //       at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:172)
    //       at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
    //       at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
    //       at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
    //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:113)
    //       at java.util.Optional.map(Optional.java:260)
    //   See https://diff.blue/R026 to resolve this issue.

    ClienteJpaRepository clienteJpaRepository = mock(ClienteJpaRepository.class);
    when(clienteJpaRepository.findByCpf(Mockito.<String>any())).thenReturn(Optional.of(mock(ClienteEntity.class)));
    ModelMapper modelMapper = mock(ModelMapper.class);
    Cliente cliente = new Cliente();
    when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(cliente);
    assertSame(cliente, (new ClientePersistencePortImpl(clienteJpaRepository, modelMapper)).findByCpf("Cpf"));
    verify(clienteJpaRepository).findByCpf(Mockito.<String>any());
    verify(modelMapper).map(Mockito.<Object>any(), Mockito.<Class<Object>>any());
  }
}

