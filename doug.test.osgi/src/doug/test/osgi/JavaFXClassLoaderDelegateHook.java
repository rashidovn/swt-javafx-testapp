package doug.test.osgi;

import org.eclipse.osgi.internal.hookregistry.ClassLoaderHook;
import org.eclipse.osgi.internal.hookregistry.HookConfigurator;
import org.eclipse.osgi.internal.hookregistry.HookRegistry;
import org.eclipse.osgi.internal.loader.ModuleClassLoader;

@SuppressWarnings("restriction")
public class JavaFXClassLoaderDelegateHook extends ClassLoaderHook implements HookConfigurator {

	@Override
	public void addHooks(HookRegistry hookRegistry) {
		hookRegistry.addClassLoaderHook(this);
	}

	@Override
	public Class<?> postFindClass(String name, ModuleClassLoader classLoader) throws ClassNotFoundException {
		if (name.startsWith("javafx."))
			return ClassLoader.getSystemClassLoader().loadClass(name);
		else
			return null;
	}

}
