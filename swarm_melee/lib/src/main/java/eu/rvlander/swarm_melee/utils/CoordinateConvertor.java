package eu.rvlander.swarm_melee.utils;

public class CoordinateConvertor {
  private Point sourceOrigin;
  private Point targetOrigin;
  private float scaler;
  private float signX;
  private float signY;

  public CoordinateConvertor(CoordinateSpace sourceSpace, CoordinateSpace targetSpace) {
    sourceOrigin = sourceSpace.getOrigin();
    this.computeSigns(sourceSpace, targetSpace);
    float ratio = this.computeAspectRatio(sourceSpace);
    this.computeScalerAndOrigin(ratio, sourceSpace, targetSpace);
  }

  private float computeAspectRatio(CoordinateSpace space) {
    return space.getWidth() / (float) space.getHeight();
  }

  private void computeScalerAndOrigin(float aspectRatio, CoordinateSpace sourceSpace,
      CoordinateSpace targetSpace) {
    float possibleWidth = targetSpace.getHeight() * aspectRatio;

    if (possibleWidth > targetSpace.getWidth()) {
      scaler = targetSpace.getWidth() / (float) sourceSpace.getWidth();
      targetOrigin = new Point(targetSpace.getOrigin().getX(), (int) (targetSpace.getOrigin().getY()
          + signY * (targetSpace.getHeight() - sourceSpace.getWidth() * scaler / aspectRatio) / 2));
    } else {
      scaler = targetSpace.getHeight() / (float) sourceSpace.getHeight();
      targetOrigin = new Point(
          (int) (targetSpace.getOrigin().getX() + signX
              * (targetSpace.getWidth() - sourceSpace.getHeight() * scaler * aspectRatio) / 2),
          targetSpace.getOrigin().getY());
    }
  }

  private void computeSigns(CoordinateSpace sourceSpace, CoordinateSpace targetSpace) {
    signX = Math.signum(sourceSpace.getRelativeWidth() * targetSpace.getRelativeWidth());
    signY = Math.signum(sourceSpace.getRelativeHeight() * targetSpace.getRelativeHeight());
  }

  public Point convertPoint(Point point) {
    return point.minus(sourceOrigin).scale(signX * scaler, signY * scaler).add(targetOrigin);
  }

  public int convertDistance(int distance) {
    return (int) (distance * scaler);
  }

}
