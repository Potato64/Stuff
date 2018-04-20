import java.util.Random;

public class Network 
{
	int num_layers;
	int[] sizes;
	double[][] biases;
	double[][][] weights;
	
	Network(int[] sizes)
	{
		num_layers = sizes.length;
		this.sizes = sizes;
		Random rand = new Random();
		biases = new double[sizes.length - 1][];
		for (int c = 0; c < biases.length; c++)
		{
			biases[c] = new double[sizes[c+1]];
			for (double bias : biases[c])
			{
				bias = rand.nextGaussian();
			}
		}
		weights = new double[sizes.length - 1][][];
		for (int c = 0; c < weights.length; c++)
		{
			weights[c] = new double[sizes[c+1]][];
		}
	}
}
