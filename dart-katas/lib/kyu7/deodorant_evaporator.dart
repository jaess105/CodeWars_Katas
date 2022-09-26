import "dart:core";
import "dart:math";

// int evaporator(double content, double evap_per_day, double threshold) {
//   threshold *= content * 0.01;
//   int days = 0;
//   for (; content > threshold; days++) {
//     content -= (content * evap_per_day * 0.01);
//   }
//   return days;
// }

/// increase over n years with k_0 being the start value: k_n = k_0 * ((100 + p) / 100 )^n
/// thereby decrease is calculated as: k_n = k_0 * ((100 - p) / 100 )^n
/// 
/// k_n = k_0 * ((100 - p) / 100 )^n | /k_0
/// k_n / k_0 = ((100 - p) / 100 )^n | log on both sides
/// log(k_n / k_0 ) = log(((100 - p) / 100 )^n)
/// log(k_n / k_0 ) = n * log(((100 - p) / 100 ))
/// log(k_n / k_0 ) / log(((100 - p) / 100 )) = n 
/// n = log(k_n / k_0 ) / log(((100 - p) / 100 ))
/// for our case k_0 = content, p = evap_per_day and 
/// k_n is given as: threshold * 0.01 * content
/// =>  n = log((threshold * 0.01 * content) / content ) / log(((100 - evap_per_day) / 100 ))
/// <=> n = log(threshold * 0.01) / log((100 - evap_per_day) / 100 )
int evaporator(double content, double evap_per_day, double threshold) {
  return (log(threshold * 0.01) / log((100 - evap_per_day) / 100)).ceil();
}

void main(List<String> args) {
  print(evaporator(10, 10, 5));
}
