import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Network 
{
	private int num_layers;
	private int[] sizes;
	private double[][] biases;
	private double[][][] weights;
	
	public Network(int[] sizes)
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
	
	private double[] sigmoid(double[] z)
	{
		double[] array = new double[z.length];
		for (int c = 0; c < array.length; c++)
		{
			array[c] = 1.0/(1.0 + Math.exp(z[c]));
		}
		return array;
	}
	
	private double[] feedForward(double[] input)
	{
		double[][] outputs = new double[num_layers][];
		outputs[0] = input;
		for (int layer = 1; layer < num_layers; layer++)
		{
			outputs[layer] = new double[sizes[layer]];
			for (int neuron = 0; neuron < sizes[layer]; neuron++)
			{
				int sum = 0;
				for (int output = 0; output < sizes[layer - 1]; output++)
				{
					sum += outputs[layer - 1][output] * weights[layer][neuron][output];
				}
				outputs[layer][neuron] = sum + biases[layer][neuron];
			}
			outputs[layer] = sigmoid(outputs[layer]);
		}
		return outputs[num_layers - 1];
	}
	
	public void SGD(double[][] training_data, int epochs, int mini_batch_size, double eta, double[][] test_data)
	{
		int n_test = 0;
		if (test_data != null)
		{
			n_test = test_data.length;
		}
		int n = training_data.length;
		for (int c = 0; c < epochs; c++)
		{
			Collections.shuffle(Arrays.asList(training_data));
			double[][][] mini_batches = new double[n / mini_batch_size + 1][][];
			for (int i = 0; i * mini_batch_size <= training_data.length; i++)
			{
				int start = i * mini_batch_size;
				mini_batches[i] = Arrays.copyOfRange(training_data, start, (start + mini_batch_size < training_data.length) ? start + mini_batch_size : training_data.length);
			}
			for(double[][] mini_batch : mini_batches)
			{
				update_mini_batch(mini_batch, eta);
			}
			if (test_data != null)
			{
				System.out.println("Epoch " + c + ": " + evaluate(test_data) + " / " + n_test);
			}
			else
			{
				System.out.println("Epoch " + c + " complete");
			}
		}
	}
	
	private void update_mini_batch(double[][] mini_batch, double eta)
	{
		double[][] nabla_b = new double[biases.length][];
		for (int c = 0; c < biases.length; c++)
		{
			nabla_b[c] = new double[biases[c].length];
		}
		double[][] nabla_w = new double[biases.length][];
		for (int c = 0; c < biases.length; c++)
		{
			nabla_w[c] = new double[biases[c].length];
		}
		for (int x = 0; x < mini_batch.length; x++)
		{
			for(int y = 0; y < mini_batch[x].length; y++)
			{
				double[][][] delta_nabla = backprop(x, y);
				double[][] delta_nabla_b = delta_nabla[0];
				double[][] delta_nabla_w = delta_nabla[1];
			}
		}
	}
	
	private double[][][] backprop(int x, int y)
	{
		
	}
	
	private int evaluate(double[][] test_data)
	{
		
	}
}
