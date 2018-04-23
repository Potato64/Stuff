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
			for(int i = 0; i < weights[c].length; i++)
			{
				weights[c][i] = new double[sizes[c]];
				for(double weight : weights[c][i])
				{
					weight = rand.nextGaussian();
				}
			}
		}
	}
	
	double[] sigmoid(double[] z)
	{
		double[] array = new double[z.length];
		for (int c = 0; c < array.length; c++)
		{
			array[c] = 1.0/(1.0 + Math.exp(z[c]));
		}
		return array;
	}
	
	double[] feedForward(double[] input)
	{
		for (int c = 0; c < sizes.length - 1; c++)
		{
			double[] outputs = new double[sizes[c + 1]];
			for (int i = 0; i < output.length; i++)
			{
				
			}
		}
	}
}
