// Interface Weapon
abstract class Weapon {
  void aimAndFire();
}

// Classe concreta BaseWeapon que implementa a interface Weapon
class BaseWeapon implements Weapon {
  @override
  void aimAndFire() {
    print("Atirando com a arma base.");
  }
}

// Classe abstrata WeaponDecorator que também implementa Weapon
abstract class WeaponDecorator implements Weapon {
  late Weapon weapon;

  WeaponDecorator(Weapon weapon) {
    this.weapon = weapon;
  }

  @override
  void aimAndFire() {
    weapon.aimAndFire();
  }
}

// Exemplo de um decorador específico (Scope) que adiciona funcionalidade
class Scope extends WeaponDecorator {
  Scope(Weapon weapon) : super(weapon);

  @override
  void aimAndFire() {
    super.aimAndFire();
    print("Usando uma mira para melhorar a precisão.");
  }
}

// Exemplo de um decorador específico (Suppressor) que adiciona funcionalidade
class Suppressor extends WeaponDecorator {
  Suppressor(Weapon weapon) : super(weapon);

  @override
  void aimAndFire() {
    super.aimAndFire();
    print("Usando um supressor para reduzir o ruído.");
  }
}

void main() {
  // Criar uma arma base
  Weapon baseWeapon = BaseWeapon();

  // Adicionar acessórios à arma usando o Decorator
  Weapon weaponWithScope = Scope(baseWeapon);
  Weapon weaponWithSuppressor = Suppressor(baseWeapon);

  // Testar as armas com acessórios
  print("Arma Base:");
  baseWeapon.aimAndFire();

  print("\nArma com Mira:");
  weaponWithScope.aimAndFire();

  print("\nArma com Supressor:");
  weaponWithSuppressor.aimAndFire();
}
