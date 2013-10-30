require 'mars_rover_control_unit'

describe MarsRoverControlUnit do
  it "should move foward once" do
    engine = mock()
    mars_rover = MarsRoverControlUnit.new(engine)

    expect(engine).to receive(:forward).with(1)

    mars_rover.move("f")
  end
end
