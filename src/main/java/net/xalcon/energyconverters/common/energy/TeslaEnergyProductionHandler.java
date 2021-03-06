package net.xalcon.energyconverters.common.energy;

import net.darkhax.tesla.api.ITeslaProducer;
import net.minecraftforge.fml.common.Optional;
import net.xalcon.energyconverters.EnergyConverters;
import net.xalcon.energyconverters.common.EnergyConvertersConfig;

@Optional.Interface(iface = "net.darkhax.tesla.api.ITeslaProducer", modid = "tesla")
public class TeslaEnergyProductionHandler implements ITeslaProducer
{
	private IEnergyBridgeOutputAccessProvider energyBridge;

	public TeslaEnergyProductionHandler(IEnergyBridgeOutputAccessProvider energyBridge)
	{
		this.energyBridge = energyBridge;
	}

	@Override
	@Optional.Method(modid = "tesla")
	public long takePower(long power, boolean simulated)
	{
		double ratio = EnergyConvertersConfig.teslaConversion;
		return (long)(energyBridge.retrieveEnergyFromBridge(power * ratio, simulated) / ratio);
	}
}
